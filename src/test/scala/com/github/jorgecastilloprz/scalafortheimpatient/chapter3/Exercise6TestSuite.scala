package com.github.jorgecastilloprz.scalafortheimpatient.chapter3

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import scala.collection.mutable.ArrayBuffer

/**
 * @author jorge
 * @since 25/05/15
 */
@RunWith(classOf[JUnitRunner])
class Exercise6TestSuite extends FunSuite {

  test("Array(3, -1, 129, 911, -45, 0, -1, -3, 9, 17, 51, 267, 12, 5) in reverse and sorted order is equals to " +
    "Array(911, 267, 129, 51, 17, 12, 9, 5, 3, 0, -1, -1, -3, -45)") {

    assert(Exercise6.rearrangeToReverseAndSortedOrder(Array(3, -1, 129, 911, -45, 0, -1, -3, 9, 17, 51, 267, 12, 5))
      === Array(911, 267, 129, 51, 17, 12, 9, 5, 3, 0, -1, -1, -3, -45))
  }

  test("ArrayBuffer(3, -1, 129, 911, -45, 0, -1, -3, 9, 17, 51, 267, 12, 5) in reverse and sorted order is equals to " +
    "ArrayBuffer(911, 267, 129, 51, 17, 12, 9, 5, 3, 0, -1, -1, -3, -45)") {

    assert(Exercise6.rearrangeToReverseAndSortedArrayBuffer(
      ArrayBuffer(3, -1, 129, 911, -45, 0, -1, -3, 9, 17, 51, 267, 12, 5)) ===
      ArrayBuffer(911, 267, 129, 51, 17, 12, 9, 5, 3, 0, -1, -1, -3, -45))
  }
}
