package src.main.scala

object TypeExample extends App {

  type MovieRating = (Int, Double)
  type UserRatingPair = (Int, (MovieRating))
  def makePairs(userRatings: UserRatingPair): ((Int, Double)) = {
    val movieRating1 = userRatings._2

    val movie1 = movieRating1._1
    val rating1 = movieRating1._2

    (movie1, rating1)
  }

}
