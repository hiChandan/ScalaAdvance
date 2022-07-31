object VarianceExample extends App {
  trait Animal
  class Cat extends Animal
  class Dog extends Animal
// Useful in generic collection
//  class Invariance[A] Invariance
//  class Invariance[-A] Contravariance
  class Invariance[+A] // co variance
  def doSomething(list: Invariance[Animal]) = {
    println("I am doiing something")
  }
  //  val animal = new Animal()
  doSomething(new Invariance[Dog]) // co -variance
  doSomething(new Invariance[Cat]) // contra -variance
  doSomething(new Invariance[Animal]) // variance
}
