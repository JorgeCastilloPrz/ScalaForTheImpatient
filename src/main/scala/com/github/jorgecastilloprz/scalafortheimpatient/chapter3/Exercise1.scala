package com.github.jorgecastilloprz.scalafortheimpatient.chapter3

import scala.util.Random

/**
 * Write a code snippet that sets a to an array of n random integers between 0 (inclusive) and n (exclusive).
 *
 * @author jorge
 * @since 25/05/15
 */
object Exercise1 {

  def main(args: Array[String]) {
    val a = createArrayOfRandomInts(10)
    println(a.mkString(" "))
  }

  def createArrayOfRandomInts(n: Int): Array[Int] = {
    (1 to n).toArray.map(Random.nextInt(_))
  }
}
