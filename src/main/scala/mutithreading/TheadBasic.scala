package mutithreading

object TheadBasic extends App {

  new Thread(new Runnable {
    def run(): Unit =
      for (i <- 1 to 100) {
        println(i)
        Thread.sleep(200)
      }
  }).start()
//
//  for (i <- 1 to 100) {
//    println(i)
//    Thread.sleep(100)
//  }

  for (c <- 'A' to 'Z') {
    println(c)
    Thread.sleep(200)

  }
}
