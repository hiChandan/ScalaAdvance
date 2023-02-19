package mutithreading
//lazy evaluation helps us in optimizing the process by evaluating the expression only when it’s needed and avoiding unnecessary overhead.
object ThreadvsLazy extends App {
  val geeks = List(1, 2, 3, 4, 5)
//  val output = geeks.map(l => l * 2)
  lazy val output = geeks.map(l => l * 2)

  println(output)

}
