package niket

import niket.dp.Survivor2
import org.specs2._

class JosephusSpec extends Specification {
  override def is =
    s2"""
        Josephus should

        validate if n or k is zero or negative   $validate

        return 1 if n == 1 $nEq1

        return if n == k $nEqk

        return 3 if n == 3 and k == 2 $n3k2

        return if n is large and k == 2 $nLargek2

        return if n is small and k is large $nSmallkLarge

        return if n is large and k is large $nLargekLarge
    """.stripMargin

  def validate = (Survivor2().isValid(0, 1) || Survivor2().isValid(1, 0) || Survivor2().isValid(0, 0)) must_== false

  def nEq1 = Survivor2().findPosition(1, 7).get must_== 1

  def nEqk = Survivor2().findPosition(4, 4).get must_== 2

  def n3k2 = Survivor2().findPosition(3, 2).get must_== 3

  def nLargek2 = Survivor2().findPosition(999999, 2).get must_== 951423

  def nSmallkLarge = Survivor2().findPosition(7, 999999).get must_== 2

  def nLargekLarge = Survivor2().findPosition(999999, 999999).get must_== 295011
}
