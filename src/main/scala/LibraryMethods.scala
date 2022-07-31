object LibraryMethods {

  trait SummableTrait[T] {
    def sumIt(l: List[T]): T
  }

  implicit object SumInt extends SummableTrait[Int] {
    override def sumIt(l: List[Int]): Int = l.sum
  }

  implicit object SumString extends SummableTrait[String] {
    override def sumIt(l: List[String]): String = l.mkString("")
  }

  def processData[T](l: List[T])(implicit summable: SummableTrait[T]): T = {
    summable.sumIt(l)
  }

  def main(args: Array[String]): Unit = {
    print(processData(List(1, 3, 4, 5)))
    print(processData(List("Hi", " World")))
    //print(processData(List(true,false))) //Not possible
  }

}
