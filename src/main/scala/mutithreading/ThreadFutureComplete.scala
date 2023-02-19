package mutithreading

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object ThreadFutureComplete extends App {

  def add() = {
    var res = 0
    for (i <- (1 to 100)) {
      res += i
    }
    res
  }
  val t1 = System.nanoTime()
  val f = Future(add())
  f.onComplete({
    case Success(n)  => println(n)
    case Failure(ex) => println("Failed with exception" + ex.getMessage)
  })
  println("Future " + (System.nanoTime - t1))
  val t2 = System.nanoTime()
  println("Simple Blocking " + add())
  println("Simple " + (System.nanoTime() - t2))
}
