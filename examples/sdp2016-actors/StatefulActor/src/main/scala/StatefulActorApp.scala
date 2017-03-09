import akka.actor._
import CoffeeProtocol._

class Barrister extends Actor with ActorLogging {

  def receive = {

    case CustomerOrder(c) =>
      // make coffee and give coffee to person at till
      var message = s"${self.path.name} is making coffee $c"

      if (self.path.name == "the-one-with-the-hipster-beard")
        message += " with llama milk"

      log.info(message)
      Thread.sleep(2000)
      sender ! Coffee(c)
  }
}

class CoffeeShop extends FSM[State, Data] {

  startWith(Closed, Uninitialised)

  when(Closed) {
    case Event(Open, _) =>
      // spawn barristers to handle orders
      context.actorOf(Props[Barrister], "john")
      context.actorOf(Props[Barrister], "maria")
      context.actorOf(Props[Barrister], "james")
      context.actorOf(Props[Barrister], "the-one-with-the-hipster-beard")
      goto(Opened) using OrderQueue(Map.empty)

    case Event(Barristas, _) =>
      println(context.children)
      sender ! context.children
      stay
  }

  when(Opened) {
    case Event(CustomerOrder(name), o@OrderQueue(q)) =>
      val barrista = getNextAvailableBarrista
      barrista.tell(CustomerOrder(name), self)
      sender.tell(Info("I will be making your coffee today"), barrista)
      stay using o.copy(queue = q + (barrista -> name))
    case Event(Coffee(name), o@OrderQueue(q)) =>
      log.info(s"Got coffee back from ${sender.path.name}")
      val newQueue = q - sender
      stay using o.copy(queue = newQueue)
    case Event(Barristas, _) =>
      sender ! context.children
      stay
    case Event(Queue, o@OrderQueue(q)) =>
      sender ! q
      stay
  }

  onTransition {
    case _ -> Opened =>
      log.info("Transitioning to Active")
    case _ -> Closed =>
      // let all the barristers for
      log.info("Transitioning to IDLE")
      context.children.foreach {
        _ ! PoisonPill
      }
  }

  def getNextAvailableBarrista: ActorRef = {
    stateData match {
      case OrderQueue(m) =>
        context.children.filterNot(c => m.keys.toList.contains(c)).head
      case Uninitialised =>
        scala.util.Random.shuffle(context.children).head
    }
  }

  initialize()
}

object StatefulActorApp extends App {
  val system = ActorSystem("hipstercoffee")
  val shop = system.actorOf(Props[CoffeeShop], "hipstercoffeeshop")
  shop ! Open
  shop ! CustomerOrder("Cappuccino")
  shop ! Queue
  Thread.sleep(5)
  shop ! Queue
  system.terminate()
}
