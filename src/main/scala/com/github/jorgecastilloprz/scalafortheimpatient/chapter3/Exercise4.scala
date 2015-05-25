package com.github.jorgecastilloprz.scalafortheimpatient.chapter3

/**
 * Given an array of integers, produce a new array that contains all positive values of the original array, in their
 * original order, followed by all values that are zero or negative, in their original order.
 *
 * @author jorge
 * @since 25/05/15
 */
object Exercise4 {

  def main(args: Array[String]) {
    println(getReorderedArray(Array(10, -20, 23, 93, 5, -2, 10, 0, 3, -903)).mkString(" "))
  }

  def getReorderedArray(mArray: Array[Int]): Array[Int] = {
    (mArray.filter(_ > 0).toBuffer ++= mArray.filter(_ <= 0)).toArray[Int]
  }
}
