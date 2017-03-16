package singletonpattern

object SingletonEager {
  private val sc: SingletonEager = new SingletonEager

  def getInstance: SingletonEager = {
    return sc
  }
}

class SingletonEager private() {
}
