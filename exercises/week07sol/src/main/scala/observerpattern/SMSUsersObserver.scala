package observerpattern

import java.util.Observable
import java.util.Observer

class SMSUsersObserver(val observable: Observable, val userInfo: String) extends Observer {
  private var desc: String = null

  def subscribe() = {
    println("Subscribing " + userInfo + " to " + ((observable).asInstanceOf[CommentaryObjectObservable]).subjectDetails + " ...")
    observable.addObserver(this)
    println("Subscribed successfully.")
  }

  def unSubscribe() = {
    println("Unsubscribing " + userInfo + " to " + (observable.asInstanceOf[CommentaryObjectObservable]).subjectDetails + " ...")
    observable.deleteObserver(this)
    println("Unsubscribed successfully.")
  }

  def update(o: Observable, arg: Any) = {
    desc = arg.asInstanceOf[String]
    println("[" + userInfo + "]: " + desc)
  }
}
