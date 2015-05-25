package com.github.jorgecastilloprz.scalafortheimpatient.chapter3

/**
 * Repeat the preceding assignment: Write a loop that swaps adjacent elements of an array of inteers. For example,
 * Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5). This time produce a new array with the swapped values.
 *
 * @author jorge
 * @since 25/05/15
 */
object Exercise3 {

  def main(args: Array[String]) {
    println(swapArrayPairs(Array(1, 2, 3, 4, 5)).mkString(" "))
  }

  /**
   * For every group of 2 items you reverse them and yield the new inverse pair
   * @param mArray
   * @return
   */
  def swapArrayPairs(mArray: Array[Int]): Array[Int] = {
    (for {
      b <- mArray.grouped(2)
      c <- b.reverse
    } yield c).toArray
  }
}