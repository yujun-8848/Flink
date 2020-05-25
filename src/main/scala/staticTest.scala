object staticTest {

  def main(args: Array[String]): Unit = {

    //val pig = new Pig("a")
    val pig = Pig.apply("12")
    println(Pig.sum)
    println(pig.name)
    val pig1 = Pig.apply()


  }

}

//伴生类
class Pig(pname: String) {
  var name: String = pname

}

//伴生对象
object Pig {
  var sum: Int = _

  def apply(name: String): Pig = {
    sum += 1
    new Pig(name)
  }

  def apply(): Pig = {
    new Pig("nnonono")
  }

}
