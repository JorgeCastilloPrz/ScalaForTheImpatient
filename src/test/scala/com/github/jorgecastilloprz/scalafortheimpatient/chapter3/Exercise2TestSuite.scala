package com.github.jorgecastilloprz.scalafortheimpatient.chapter3

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * @author jorge
 * @since 25/05/15
 */
@RunWith(classOf[JUnitRunner])
class Exercise2TestSuite extends FunSuite {

  test("Array(1, 2, 3, 4, 5) with swapped elements results in Array(2, 1, 4, 3, 5)") {
    assert(Exercise2.swapArrayPairs(Array(1, 2, 3, 4, 5)) === Array(2, 1, 4, 3, 5))
  }

  test("Array(2, 4, 6, 8, 10, 12, 14, 16, 18) with swapped elements results in Array(4, 2, 8, 6, 12, 10, 16, 14, 18)") {
    assert(Exercise2.swapArrayPairs(Array(2, 4, 6, 8, 10, 12, 14, 16, 18)) === Array(4, 2, 8, 6, 12, 10, 16, 14, 18))
  }
}
