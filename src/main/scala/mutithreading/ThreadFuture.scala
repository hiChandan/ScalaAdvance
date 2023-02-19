package mutithreading

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object ThreadFuture extends App {
  def run(): Unit =
    for (i <- 1 to 100) {
      println(i)
//      Thread.sleep(200)
    }

  println("Start")
  val r: Unit = {
    Future(
//      println("This is supposed to be in future")
      run()
    )
    Thread.sleep(100)
  }
  println("End")

}
