package com.github.jorgecastilloprz.scalafortheimpatient.chapter3

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * @author jorge
 * @since 25/05/15
 */
@RunWith(classOf[JUnitRunner])
class Exercise7TestSuite extends FunSuite {

  test("Removing duplicates from Array(9, 2, 1, 1, 9, 2, 0, 1, 10, 15, -1, -9, 0, -9) should give us the result " +
    "Array(9, 2, 1, 0, 10, 15, -1, -9)") {

    assert(Exercise7.removeDuplicates(Array(9, 2, 1, 1, 9, 2, 0, 1, 10, 15, -1, -9, 0, -9)) ===
      Array(9, 2, 1, 0, 10, 15, -1, -9))
  }

  test("Removing duplicates from Array(1,1,1,1,1,1,1,1) should be totally equal to Array(1)") {
    assert(Exercise7.removeDuplicates(Array(1,1,1,1,1,1,1,1)) === Array(1))
  }
}
