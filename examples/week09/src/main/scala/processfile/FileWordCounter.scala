import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.util.Timeout
import akka.pattern.ask

import scala.concurrent.duration._
import scala.io.Source.fromInputStream
import scala.concurrent.Await 
import scala.concurrent.Future

import scala.language.postfixOps

/**
  * Created by raitis on 19/03/15.
  */
case class StartProcessingFile()

case class ProcessingLineMsg(line: String)

case class processingLineTotal(words: Int)


class FileOfWordsCounter(fileName: String) extends Actor {

  private var running = false

  // for specific output
  private var fileSender: Option[ActorRef] = None

  private var lineCounter = 0
  private var runningTotal = 0
  private var linesProcessed = 0


  override def receive = {

    case StartProcessingFile =>
      if (running)
        println("already running")
      else {
        println("Started running")
        running = true

        // ref to parrent process
        // for advance output
        fileSender = Some(sender)

        val stream = getClass.getResourceAsStream("/" + fileName)
        val lines = fromInputStream( stream ).getLines
        // open actor for each line
        lines.foreach {
          line => {
            context.actorOf(Props[WordsCounterActor], "wcactor" + lineCounter) ! ProcessingLineMsg(line)
            println(s"start actor " + "wcactor " + lineCounter)
            lineCounter += 1
          }
        }
      }

    case processingLineTotal(words) =>
      println("line Processed " + words)
      runningTotal += words
      linesProcessed += 1
      if (linesProcessed == lineCounter) {
        // basic output
        println("finish, theres is " + runningTotal + " words")
        // or better output:
        fileSender.map(_ ! runningTotal)
      }

    case _ =>
      println("wrong message")
  }
}


// count words in line and sends them to processingLineTotal

class WordsCounterActor extends Actor {
  override def receive = {
    case ProcessingLineMsg(line) =>
      print("Processing line... ")
      val wordsInLine = line.split(" ").length
      println(s"$wordsInLine words in this line")

      sender ! processingLineTotal(wordsInLine)

    case _ =>
      println("wrong message")
  }
}


object MainCounter extends App {

  val system = ActorSystem("wordsCounterSystem")
  val myactor = system.actorOf(Props(new FileOfWordsCounter("text.txt")), "wcountactor")

  implicit val timeout = Timeout(30 seconds)
  val future = myactor ? StartProcessingFile

  system.terminate()

}
