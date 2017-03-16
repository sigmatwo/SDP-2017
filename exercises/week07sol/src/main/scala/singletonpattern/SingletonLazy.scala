package singletonpattern

object SingletonLazy {
  private var sc: SingletonLazy = null

  def getInstance: SingletonLazy = {
    if (sc == null) {
      sc = new SingletonLazy
    }
    return sc
  }
}

class SingletonLazy private() {
}
