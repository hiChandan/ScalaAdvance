package src.main.scala

object FoldAndReduceFunctionalWay extends App {
  object FoldEg extends App {

    val list = List(1, 2, 3, 4, 5, 6)

    println(list.sum)
    def sum = (x: Int, y: Int) => {

      val sum1 = x + y
      println(s"$x and $y is $sum1")
      sum1

    }
    // Intitial value
    println(list.fold(0)(sum))
    println(list.fold(0)((x: Int, y: Int) => x + y))
    println(list.foldLeft(0)(sum))
    println(list.foldRight(0)(sum))
    // Reduce -  No initial value blows on empty
    println(list.reduce(sum))
    println(list.reduceLeft(sum))
    println(list.reduceRight(sum))

  }

}
