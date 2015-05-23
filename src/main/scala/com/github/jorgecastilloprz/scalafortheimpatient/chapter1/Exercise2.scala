package com.github.jorgecastilloprz.scalafortheimpatient.chapter1

import scala.math.sqrt;
import scala.math.pow;

/**
 * In the Scala REPL (i will do it here), compute the square root of 3, and then square that value.
 * ¿By how much does the result differ from 3? (Hint: The res variables are your firend.)
 *
 * @author jorge
 * @since 23/05/15
 */
object Exercise2 {

  def main(args: Array[String]) {
    println("Result after making square root from 3 and then square: " + squareRootFollowedBySquare(3));
  }

  def squareRootFollowedBySquare(x: Int): Double = {
    val squareRootValue = sqrt(x)
    val squareValue = pow(squareRootValue, 2);
    squareValue
  }
}
