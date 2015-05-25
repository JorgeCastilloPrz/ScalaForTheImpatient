package com.github.jorgecastilloprz.scalafortheimpatient.chapter3

import scala.collection.mutable.ArrayBuffer

/**
 * How do you rearrange the elements of an Array[Int] so that they appear in reverse sorted order? How do you do the
 * same with an ArrayBuffer[Int] ?
 *
 * Both of them can be solved by the same way
 *
 * @author jorge
 * @since 25/05/15
 */
object Exercise6 {

  def main(args: Array[String]) {
    println(rearrangeToReverseAndSortedOrder(Array(3, -1, 129, 911, -45, 0, -1, -3, 9, 17, 51, 267, 12, 5))
      .mkString(" "))

    println(rearrangeToReverseAndSortedArrayBuffer(ArrayBuffer(3, -1, 129, 911, -45, 0, -1, -3, 9, 17, 51, 267, 12, 5))
      .mkString(" "))
  }

  def rearrangeToReverseAndSortedOrder(values: Array[Int]): Array[Int] = {
    values.reverse.sorted
  }

  def rearrangeToReverseAndSortedArrayBuffer(values: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    values.reverse.sorted
  }
}
