import com.typesafe.scalalogging.LazyLogging
//Let's understand how loggging works in SCALA

object LoggingExample extends LazyLogging {

  def main(args: Array[String]): Unit = {

    val list = (1 to 10).toList
    logger.info("Logging Started")
    list
      .foreach(p => {
        if (p % 5 == 0)
          logger.debug(p.toString)
      })

    list
      .map(x => x % 5)
      .foreach(e => {
        try (e / e)
        catch {
          case ex: Throwable =>
            logger.error(s"error found  for $e and error is ${ex.getMessage}")
        } finally {
          logger.info("Error exception block completed")
        }

      })
    logger.info("Logging Completed")
  }
}
