package com.github.jorgecastilloprz.scalafortheimpatient.chapter3

/**
 * Write a loop that swaps adjacent elements of an array of inteers. For example, Array(1, 2, 3, 4, 5) becomes
 * Array(2, 1, 4, 3, 5)
 *
 * @author jorge
 * @since 25/05/15
 */
object Exercise2 {

  def main(args: Array[String]) {
    print(swapArrayPairs(Array(1, 2, 3, 4, 5)).mkString(" "))
  }

  def swapArrayPairs(mArray: Array[Int]): Array[Int] = {
    for (pos <- mArray.indices if pos % 2 != 0) {
      val aux = mArray(pos)
      mArray(pos) = mArray(pos - 1)
      mArray(pos - 1) = aux
    }

    mArray
  }
}
