package singletonpattern

object SingletonLazyMultithreaded {
  private var sc: SingletonLazyMultithreaded = null

  def getInstance: SingletonLazyMultithreaded = {
    if (sc == null) {
      sc = new SingletonLazyMultithreaded
    }
    return sc
  }
}

class SingletonLazyMultithreaded private() {
}
