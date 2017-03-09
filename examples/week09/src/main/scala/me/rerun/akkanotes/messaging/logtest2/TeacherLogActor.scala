package me.rerun.akkanotes.messaging.logtest2

import akka.actor.{Actor, ActorLogging}
import me.rerun.akkanotes.messaging.protocols.TeacherProtocol.{QuoteRequest, QuoteResponse}

import scala.util.Random

/*
 * Teacher with Logging
 * 
 */

class TeacherLogActor extends Actor with ActorLogging {

  val quotes = List(
    "Moderation is for cowards",
    "Anything worth doing is worth overdoing",
    "The trouble is you think you have time",
    "You never gonna know if you never even try")

  def receive = {

    case QuoteRequest => {

      //get a random element (for now)
      log.info(QuoteResponse(quotes(Random.nextInt(quotes.size))).toString())

      log.info("Quote printed") //This message is just to assert from the testcase

    }

  }

  def quoteList = quotes

}