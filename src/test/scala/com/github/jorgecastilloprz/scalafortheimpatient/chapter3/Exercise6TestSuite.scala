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
    "Array(-45, -3, -1, -1, 0, 3, 5, 9, 12, 17, 51, 129, 267, 911)") {

    assert(Exercise6.rearrangeToReverseAndSortedOrder(Array(3, -1, 129, 911, -45, 0, -1, -3, 9, 17, 51, 267, 12, 5))
      === Array(-45, -3, -1, -1, 0, 3, 5, 9, 12, 17, 51, 129, 267, 911))
  }

  test("ArrayBuffer(3, -1, 129, 911, -45, 0, -1, -3, 9, 17, 51, 267, 12, 5) in reverse and sorted order is equals to " +
    "ArrayBuffer(-45, -3, -1, -1, 0, 3, 5, 9, 12, 17, 51, 129, 267, 911)") {

    assert(Exercise6.rearrangeToReverseAndSortedArrayBuffer(
      ArrayBuffer(3, -1, 129, 911, -45, 0, -1, -3, 9, 17, 51, 267, 12, 5)) ===
      ArrayBuffer(-45, -3, -1, -1, 0, 3, 5, 9, 12, 17, 51, 129, 267, 911))
  }
}
