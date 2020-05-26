object Lazy {

  def main(args: Array[String]): Unit = {

    lazy val res = sum(1, 2)
    println("-------")
    println("res = " + res)

  }

  def sum(num1: Int, num2: Int) = {
    println("sum...")
    num1 + num2
  }

}
