package src.main.scala

object ImplicitExample extends App {
  //Eg 1 - Custom Project methods
  implicit class customFunction(s: String) {
    implicit def nextChar() = s.map((x: Char) => (x + 1).toChar)
  }
  print("ABC".nextChar()) // No need to use class name
  //Eg 2 - Default value
  implicit val default: BigInt = 1
  @scala.annotation.tailrec
  def Factorial(x: Int)(implicit res: BigInt): BigInt = {
    if (x <= 1)
      1 * res
    else
      Factorial(x - 1)(x * res)
  }

  println(Factorial(20)(1))
  println(Factorial(20)) // no need to pass default value
}
