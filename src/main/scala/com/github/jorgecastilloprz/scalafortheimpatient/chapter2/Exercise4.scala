package com.github.jorgecastilloprz.scalafortheimpatient.chapter2

/**
 * Write a Scala equivalent for the Java loop: for (int i = 10; i >= 0; i--) System.out.println(i);
 *
 * There are plenty of ways to do this loop, but i solved it just by using method "to" from RichInt to generate a Range
 * and then reverse it. You can loop over that final sequence with a simple for.
 *
 * @author jorge
 * @since 24/05/15
 */
object Exercise4 {

  def main(args: Array[String]): Unit = {
    printValuesForInverseLoop()
  }

  def printValuesForInverseLoop() {
    for (x <- (0 to 10).reverse) println(x)
  }
}
