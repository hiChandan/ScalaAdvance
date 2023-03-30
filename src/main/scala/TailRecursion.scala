import scala.annotation.tailrec

object TailRecursion extends  App {

  @tailrec
  def sum(data:Int , n: Int): Int = {
    if (n < 0)
      data
    else
      sum(n+data,n - 1)

  }
  println(sum(0,10))
}
