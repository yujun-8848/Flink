package learn.scala

object AbstractTest {

  def main(args: Array[String]): Unit = {
    val b = new B
    val i = b.sum(2)
    println(i)
    val a = new A {
      override def sum(num: Int): Int = num * 2
    }
    val i1 = a.sum(3)
    print(i1)
  }


}
class B extends A{
  override def sum(num: Int): Int = num * 2
}
abstract class A {
  def sum(num: Int):Int
}