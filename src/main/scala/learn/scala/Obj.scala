package learn.scala

import scala.beans.BeanProperty


object Obj {

  def main(args: Array[String]): Unit = {
    val person = new Person("zx",18)
    println(person.getName)
    println(person.getAge)
    val stu = new Stu("")
    
    println(stu.getName)

  }
}

class Person(pname: String, page: Int) {
  @BeanProperty
  var name: String = pname
  @BeanProperty
  var age: Int = page

  def this(name: String) {
    this("", 0)
    this.name = name
  }

  def this(age: Int) {
    this("", 0)
    this.age = age
  }
}
class Stu(name :String) extends Person(name :String) {

}