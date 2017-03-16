package observerpattern

import observer.Observer

class SMSUsers(val subject: Subject, var userInfo: String) extends Observer {
  if (subject == null) 
    throw new IllegalArgumentException("No Publisher found.")

  private var desc: String = null

  def update(desc: String) = {
    this.desc = desc
    println("[" + userInfo + "]: " + desc)
  }

  def subscribe() = {
    println("Subscribing " + userInfo + " to " + subject.subjectDetails + " ...")
    subject.subscribeObserver(this)
    println("Subscribed successfully.")
  }

  def unSubscribe() = {
    println("Unsubscribing " + userInfo + " to " + subject.subjectDetails + " ...")
    subject.unSubscribeObserver(this)
    println("Unsubscribed successfully.")
  }
}
