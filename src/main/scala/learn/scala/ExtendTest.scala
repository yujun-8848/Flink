package learn.scala

object ExtendTest {

  def main(args: Array[String]): Unit = {
    val sub = new Sub
    sub.sayOk()

  }

  class Base{
    var n1:Int = 1
    protected var n2:Int =2
    private var n3:Int = 3

    def test1() = {
      print("thread.test1" + n3)
    }
    private def test2() = {
      print("test2")
    }
  }

  class Sub extends Base{

    def sayOk(): Unit = {
      this.n1 = 20
      this.n2 = 40

      print(this.n1 +":"+this.n2)
      test1()

    }

  }

}
