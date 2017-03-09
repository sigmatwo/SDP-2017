import akka.actor._
import com.typesafe.config.ConfigFactory

/**
  * Created by kwabena on 12/02/2016.
  */

sealed trait Message
case class Greeting(message: String) extends Message

class Hordor extends Actor with ActorLogging {

  def receive = {
    case Greeting(m) =>
      log.info(s"${self.path.name} got $m from ${sender.path.name}")
      log.warning(s"Simple mind tries to process $m")
      Thread.sleep(2000)
      sender ! Greeting("Hordor")
    case x =>
      println("Hordor!!!! ") // Surely there's a better way to display debug messages right?
  }

}

class Arya extends Actor with ActorLogging{
  def receive = {
    case Greeting(m) =>
      log.info(s"${self.path.name} got $m from ${sender.path.name}")
      sender ! s"$m to you too ${sender.path.name}"
    case x =>
      log.info(s"Got $x from ${sender.path.name}")
      println("Winter IS coming!!")
  }
}

class GrumpyImp extends Actor with ActorLogging{
  def receive = {
    case Greeting(m) =>
      log.info(s"${self.path.name} got $m from ${sender.path.name}")
      sender ! Greeting("Go away!")
    case x =>
      sender ! "Wink"
      log.info(s"Do not speak to me!!! Northern Peasant!!! AKA ${sender.path.name}")
  }
}

object RemoteActor extends App {

  val system = ActorSystem("winterfell", ConfigFactory.load.getConfig("System"))
  val hordor = system.actorOf(Props[Hordor], "hordor") // name the actor within the system
  val arya = system.actorOf(Props[Arya], "Arya")
  val tyrion = system.actorOf(Props[GrumpyImp], "Tyrion")
  hordor ! "Hello"
  hordor ! "Do you say anything besides hordor?"

  hordor.tell(Greeting("Good morning!!"), arya)

  arya.tell(Greeting("Don't expect to get anything out of that one"), tyrion)

  tyrion.tell(Greeting("Hordor"), hordor)

  hordor ! PoisonPill

  system.terminate()

}
