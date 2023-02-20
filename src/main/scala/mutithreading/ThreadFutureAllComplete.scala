package mutithreading

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration.NANOSECONDS
import scala.io.Source
import scala.util.{Failure, Success}

object ThreadFutureAllComplete extends App {
  def getData(s: String, i: Int) = {
    val f1 = Source.fromURL(s)
    val res = s + " " + f1.take(10).toList
    f1.close()
    var d = 0
    for (a <- 1 to i) {
      d += a
    }

    d
  }

  import java.lang.management.ManagementFactory

  def runAndTime(f: => Unit) = {
    val start = ManagementFactory.getThreadMXBean.getCurrentThreadCpuTime
    f
    NANOSECONDS.toMillis(
      ManagementFactory.getThreadMXBean.getCurrentThreadCpuTime - start
    )
  }
  val f1 = Future(runAndTime(getData("https://www.google.com", 20000)))
  val f2 = Future(runAndTime(getData("https://www.yahoo.com", 100)))
  val f3 = Future(runAndTime(getData("https://www.bing.com", 2000)))

  val af = Seq(f1, f2, f3)
  val all = Future.sequence(af)
  all.onComplete({
    case Success(n)  => println(n)
    case Failure(ex) => println("Failed with exception" + ex.getMessage)
  })
//  Future.firstCompletedOf(af).foreach(a => println(a))
//  Thread.sleep(3000)
//  println(all.isCompleted)
  Thread.sleep(10000)
//  println(getData("https://www.yahoo.com"))

  //Demo 3

//  readLine()

}
