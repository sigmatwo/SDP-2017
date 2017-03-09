package me.rerun.akkanotes.messaging.actormsg1

import akka.actor.{Actor, ActorLogging}
import me.rerun.akkanotes.messaging.protocols.TeacherProtocol.{QuoteRequest, QuoteResponse}

import scala.util.Random

/*
 * Teacher with parameters
 * 
 */

class TeacherLogParameterActor(quotes: List[String]) extends Actor with ActorLogging {

  lazy val _quotes = quotes

  def receive = {

    case QuoteRequest => {

      //get a random element (for now)
      log.info(QuoteResponse(_quotes(Random.nextInt(_quotes.size))).toString())

      log.info("Quote printed") //This message is just to assert from the testcase

    }

  }

  def quoteList = _quotes

}