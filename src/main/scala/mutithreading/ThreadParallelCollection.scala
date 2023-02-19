package mutithreading

import scala.collection.parallel.CollectionConverters.ImmutableIterableIsParallelizable

object ThreadParallelCollection extends App {

  for (i <- (1 to 10).par) {
    println(i)
    Thread.sleep(100)
  }
}
