package me.rerun.akkanotes.messaging.actormsg1

import akka.actor.{ActorSystem, Props}
import me.rerun.akkanotes.messaging.protocols.TeacherProtocol.QuoteRequest


/**
  * Let's have the student as a simple App now instead of an Actor for the first part.
  *
  * There's a test class which actually does the same thing as this App
  *
  */

object StudentSimulatorApp extends App {

  //Initialize the ActorSystem
  val actorSystem = ActorSystem("UniversityMessageSystem")

  //construct the Teacher Actor Ref
  val teacherActorRef = actorSystem.actorOf(Props[TeacherActor])
  //val teacherActorRef = actorSystem.actorOf(Props[TeacherLogActor])

  //send a message to the Teacher Actor
  teacherActorRef ! QuoteRequest

  //Let's wait  before we shut down the system
  Thread.sleep(1000)

  //Shut down the ActorSystem.
  actorSystem.shutdown()

} 


