package mutithreading

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.io.Source

object ThreadFutureAllComplete extends App {
  def getData(s: String) = {
    val f1 = Source.fromURL(s)
    val res = s + " " + f1.take(10).toList
    f1.close()
    res
  }

  val f1 = Future(getData("https://www.google.com"))
  val f2 = Future(getData("https://www.yahoo.com"))
  val f3 = Future(getData("https://www.bing.com"))

  val af = Seq(f1, f2, f3)
  val all = Future.sequence(af)
//  all.onComplete({
//    case Success(n)  => println(n)
//    case Failure(ex) => println("Failed with exception" + ex.getMessage)
//  })
  Future.firstCompletedOf(af).foreach(a => println(a))
  Thread.sleep(3000)
  println(all.isCompleted)
  Thread.sleep(3000)
//  println(getData("https://www.yahoo.com"))
//  readLine()

}
