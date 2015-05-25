package com.github.jorgecastilloprz.scalafortheimpatient.chapter3

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
 * @author jorge
 * @since 25/05/15
 */
@RunWith(classOf[JUnitRunner])
class Chapter3TestSuite extends FunSuite {

  /*
  1. Write a code snippet that sets a to an array of n random integers between 0 (inclusive) and n (exclusive).
   */

  test("1. Generated Array has n elements") {
    val a = createArrayOfRandomInts(10)
    assert(a.length === 10)
  }

  test("1. Generated Array has n random elements between 0 and n-1") {
    val a = createArrayOfRandomInts(5)
    for (randomNum <- a) assert(randomNum >= 0 && randomNum < 5)
  }

  def createArrayOfRandomInts(n: Int): Array[Int] = {
    (1 to n).toArray.map(Random.nextInt)
  }

  /*
  2. Write a loop that swaps adjacent elements of an array of inteers. For example, Array(1, 2, 3, 4, 5) becomes
  Array(2, 1, 4, 3, 5)
   */

  test("2. Array(1, 2, 3, 4, 5) with swapped elements results in Array(2, 1, 4, 3, 5)") {
    assert(swapArrayPairs(Array(1, 2, 3, 4, 5)) === Array(2, 1, 4, 3, 5))
  }

  test("2. Array(2, 4, 6, 8, 10, 12, 14, 16, 18) with swapped elements results in Array(4, 2, 8, 6, 12, 10, 16, 14, 18)") {
    assert(swapArrayPairs(Array(2, 4, 6, 8, 10, 12, 14, 16, 18)) === Array(4, 2, 8, 6, 12, 10, 16, 14, 18))
  }

  def swapArrayPairs(mArray: Array[Int]): Array[Int] = {
    for (pos <- mArray.indices if pos % 2 != 0) {
      val aux = mArray(pos)
      mArray(pos) = mArray(pos - 1)
      mArray(pos - 1) = aux
    }

    mArray
  }

  /*
  3. Repeat the preceding assignment: Write a loop that swaps adjacent elements of an array of integers. For example,
  Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5). This time produce a new array with the swapped values.
   */

  test("3. Array(1, 2, 3, 4, 5) with swapped elements results in Array(2, 1, 4, 3, 5)") {
    assert(swapArrayPairsInNewArray(Array(1, 2, 3, 4, 5)) === Array(2, 1, 4, 3, 5))
  }

  test("3. Array(2, 4, 6, 8, 10, 12, 14, 16, 18) with swapped elements results in Array(4, 2, 8, 6, 12, 10, 16, 14, 18)") {
    assert(swapArrayPairsInNewArray(Array(2, 4, 6, 8, 10, 12, 14, 16, 18)) === Array(4, 2, 8, 6, 12, 10, 16, 14, 18))
  }

  /**
   * For every group of 2 items you reverse them and yield the new inverse pair
   */
  def swapArrayPairsInNewArray(mArray: Array[Int]): Array[Int] = {
    (for {
      b <- mArray.grouped(2)
      c <- b.reverse
    } yield c).toArray
  }

  /*
  4. Given an array of integers, produce a new array that contains all positive values of the original array, in their
  original order, followed by all values that are zero or negative, in their original order.
   */

  test("4. Reordering Array(10, -20, 23, 93, 5, -2, 10, 0, 3, -903) as the question is asking results in " +
    "Array(10, 23, 93, 5, 10, 3, -20, -2, 0, -903)") {

    assert(getReorderedArray(Array(10, -20, 23, 93, 5, -2, 10, 0, 3, -903)) ===
      Array(10, 23, 93, 5, 10, 3, -20, -2, 0, -903))
  }

  def getReorderedArray(mArray: Array[Int]): Array[Int] = {
    (mArray.filter(_ > 0).toBuffer ++= mArray.filter(_ <= 0)).toArray[Int]
  }

  /*
  5. How do you compute the average of an Array[Double] ?
   */

  test("5. Average of Array(2.2, 1.2, 3.6, 5.1, 5.8, 10.99) = 4.815") {
    assert(average(Array(2.2, 1.2, 3.6, 5.1, 5.8, 10.99)) === 4.815)
  }

  def average(doubles: Array[Double]): Double = {
    doubles.sum / doubles.length
  }

  /*
  6. How do you rearrange the elements of an Array[Int] so that they appear in reverse sorted order? How do you do the
  same with an ArrayBuffer[Int] ?
   */

  test("6. Array(3, -1, 129, 911, -45, 0, -1, -3, 9, 17, 51, 267, 12, 5) in reverse and sorted order is equals to " +
    "Array(911, 267, 129, 51, 17, 12, 9, 5, 3, 0, -1, -1, -3, -45)") {

    assert(rearrangeToReverseAndSortedOrder(Array(3, -1, 129, 911, -45, 0, -1, -3, 9, 17, 51, 267, 12, 5))
      === Array(911, 267, 129, 51, 17, 12, 9, 5, 3, 0, -1, -1, -3, -45))
  }

  test("6. ArrayBuffer(3, -1, 129, 911, -45, 0, -1, -3, 9, 17, 51, 267, 12, 5) in reverse and sorted order is equals to " +
    "ArrayBuffer(911, 267, 129, 51, 17, 12, 9, 5, 3, 0, -1, -1, -3, -45)") {

    assert(rearrangeToReverseAndSortedArrayBuffer(
      ArrayBuffer(3, -1, 129, 911, -45, 0, -1, -3, 9, 17, 51, 267, 12, 5)) ===
      ArrayBuffer(911, 267, 129, 51, 17, 12, 9, 5, 3, 0, -1, -1, -3, -45))
  }

  def rearrangeToReverseAndSortedOrder(values: Array[Int]): Array[Int] = {
    values.sortWith(_ > _)
  }

  def rearrangeToReverseAndSortedArrayBuffer(values: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    values.sortWith(_ > _)
  }

  /*
  7. Write a code snippet that produces all values from an array with duplicates removed.
   */

  test("7. Removing duplicates from Array(9, 2, 1, 1, 9, 2, 0, 1, 10, 15, -1, -9, 0, -9) should give us the result " +
    "Array(9, 2, 1, 0, 10, 15, -1, -9)") {

    assert(removeDuplicates(Array(9, 2, 1, 1, 9, 2, 0, 1, 10, 15, -1, -9, 0, -9)) ===
      Array(9, 2, 1, 0, 10, 15, -1, -9))
  }

  test("7. Removing duplicates from Array(1,1,1,1,1,1,1,1) should be totally equal to Array(1)") {
    assert(removeDuplicates(Array(1, 1, 1, 1, 1, 1, 1, 1)) === Array(1))
  }

  def removeDuplicates(values: Array[Int]): Array[Int] = {
    values.distinct
  }
}
