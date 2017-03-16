package singletonpattern

import java.io.ObjectStreamException
import java.io.Serializable

@SerialVersionUID(-1093810940935189395L)
object SingletonProtected {
  private val sc: SingletonProtected = new SingletonProtected

  def getInstance: SingletonProtected = sc

  @throws[ClassNotFoundException]
  private def getClass(classname: String): Class[_] = {
    var classLoader: ClassLoader = Thread.currentThread.getContextClassLoader
    if (classLoader == null) classLoader = classOf[SingletonProtected].getClassLoader
    classLoader.loadClass(classname)
  }
}

@SerialVersionUID(-1093810940935189395L)
class SingletonProtected private() extends Serializable {
  if (SingletonProtected.sc != null) throw new IllegalStateException("Already created.")

  @throws[ObjectStreamException]
  private def readResolve: Any = SingletonProtected.sc
  

  @throws[ObjectStreamException]
  private def writeReplace: Any = SingletonProtected.sc


  @throws[CloneNotSupportedException]
  override def clone = throw new CloneNotSupportedException("Singleton, cannot be clonned")
}
