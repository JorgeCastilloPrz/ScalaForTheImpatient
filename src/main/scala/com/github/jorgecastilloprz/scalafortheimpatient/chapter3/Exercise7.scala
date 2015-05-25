package com.github.jorgecastilloprz.scalafortheimpatient.chapter3

/**
 * Write a code snippet that produces all values from an array with duplicates removed.
 *
 * @author jorge
 * @since 25/05/15
 */
object Exercise7 {

  def main(args: Array[String]) {
    println(removeDuplicates(Array(9, 2, 1, 1, 9, 2, 0, 1, 10, 15, -1, -9, 0, -9)).mkString(" "))
  }

  def removeDuplicates(values: Array[Int]): Array[Int] = {
    values.distinct
  }
}
