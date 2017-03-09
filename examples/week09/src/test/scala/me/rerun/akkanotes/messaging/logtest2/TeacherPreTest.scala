package me.rerun.akkanotes.messaging.logtest2

import akka.actor.ActorSystem
import akka.testkit.{TestActorRef, TestKit}
import me.rerun.akkanotes.messaging.protocols.TeacherProtocol.QuoteRequest
import org.scalatest.{BeforeAndAfterAll, MustMatchers, WordSpecLike}

class TeacherPreTest extends TestKit(ActorSystem("UniversityMessageSystem"))
  with WordSpecLike
  with MustMatchers
  with BeforeAndAfterAll {


  "A teacher with ActorLogging" must {

    "log a quote when a QuoteRequest message is sent" in {

      val teacherRef = TestActorRef[TeacherLogActor]
      teacherRef ! QuoteRequest

    }
  }

  override def afterAll() {
    super.afterAll()
    system.shutdown()

  }
}



