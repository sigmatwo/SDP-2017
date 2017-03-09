import akka.actor._

/**
  * Created by kwabena on 13/02/2016.
  */

sealed trait Message

case class Create(name: String) extends Message

case object YourKids extends Message

case object BecomeGrandParent extends Message

case object KillEveryone extends Message

trait Creator extends Actor with ActorLogging {
  var children: Vector[ActorRef] = Vector() // BAD FORM!!!!

  def create(name: String) = {
    val child = context.actorOf(Props[Youngling], name)
    context.watch(child)
  }

  def receive = {
    case Create(name) =>
      val child = create(name)
      child ! "Welcome My Child"
      children = children :+ child // ABSOLUTELY BAD FORM!!!
    case YourKids =>
      /*children.foreach { c =>
        c ! YourKids
        println(c)
      }*/

      if (context.children.isEmpty) {
        log.info("I have no children")
      } else {
        context.children foreach { c =>
          println(c)
          c ! YourKids
        }
      }


    case Terminated(m) => log.info(s"${m.path.name} just died")

    case BecomeGrandParent =>
      scala.util.Random.shuffle(children).head ! Create("grandchild1")

    case KillEveryone =>
      log.info("Killing everyone")
      context.children.foreach(c => c ! PoisonPill)
  }
}

class Parent extends Creator

class Youngling extends Creator


object SupervisingActors extends App {
  val system = ActorSystem("familyTree")
  val papa = system.actorOf(Props[Parent], "daddy")
  papa ! Create("firstborn")
  papa ! Create("secondborn")
  papa ! Create("thirdborn")
  papa ! YourKids
  papa ! BecomeGrandParent
  papa ! YourKids
  papa ! KillEveryone
  papa ! YourKids
  system.terminate()
}
