object TypeExample extends App {
  //Type declaration is a Scala feature that enables us to declare our own types.
  // Use for semantic only
  type MovieRating = (Int, Double)
  type UserRatingPair = (Int, (MovieRating))
  // Check use of type in below statement
//  Earlier def makePairs(userRatings: UserRatingPair):((Int, Double),(Int, Double))
  def makePairs(userRatings: UserRatingPair): (MovieRating, MovieRating) = {
    val movieRating1 = userRatings._2

    val movie1 = movieRating1._1
    val rating1 = movieRating1._2

    ((movie1, rating1), (movie1, rating1))
  }

}
//https://users.scala-lang.org/t/type-alias-vs-case-class-to-add-semantic-meaning-to-data-structures/5991/4
