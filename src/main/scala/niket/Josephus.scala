package niket

import niket.dp.Survivor2

import scala.util.{Failure, Success, Try}

trait Survivor {
  def isValid(n: Int, k: Int): Boolean = n > 0 && k > 0

  def findPosition(n: Int, k: Int): Try[Int]
}

object Josephus extends App {
  override def main(args: Array[String]): Unit = {
    if (args.length != 2) {
      println("USAGE: Josephus <number of people> <step rate>")
    } else {
      val n = args(0).toInt
      val k = args(1).toInt
      println(s"Calculating survivor position for n=$n and k=$k")
      Survivor2().findPosition(n, k) match {
        case Success(position) => println(s"Survivor position: $position")
        case Failure(ex) =>
          println(s"Failed to calculate Survivor position with error: ${ex.getMessage}")
          ex.printStackTrace()
      }
    }
  }
}


