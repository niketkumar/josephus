package niket.dp

import niket.Survivor

import scala.annotation.tailrec
import scala.util.Try

private[dp] class Survivor2 extends Survivor {
  override def findPosition(n: Int, k: Int): Try[Int] = Try(
    if (isValid(n, k)) {
      positionRecur(n, k, 0, 1) + 1
    } else {
      throw new IllegalArgumentException(s"n and k should be a nonzero positive number, found n=$n, k=$k")
    }
  )

  @tailrec private def positionRecur(n: Int, k: Int, prev: Int, i: Int): Int = {
    val curr = if (i == 1) 0 else (prev + k) % i
    if (i == n) curr else positionRecur(n, k, curr, i + 1)
  }
}

object Survivor2 {
  def apply(): Survivor2 = new Survivor2()
}