object fibbNumber extends App {
  for { i <- List.range(1, 17) } yield {
    print(fib(i) + ", ")
  }
  println("...")

  for { i <- 1 to 20 } yield {
    println(sum(i))
  }

  def fib(n: Int): Int = {

    if (n < 3)
      1
    else
      fib(n - 1) + fib(n - 2)

  }
  def sum(n: Int): Int = {
    if (n < 0)
      0
    else
      n + sum(n - 1)

  }

}
