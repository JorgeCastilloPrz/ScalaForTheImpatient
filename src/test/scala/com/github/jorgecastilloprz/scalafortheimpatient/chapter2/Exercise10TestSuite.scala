package com.github.jorgecastilloprz.scalafortheimpatient.chapter2

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * @author jorge
 * @since 24/05/15
 */
@RunWith(classOf[JUnitRunner])
class Exercise10TestSuite extends FunSuite {

  test("2 pow 3 is 8") {
    assert(Exercise10.pow(2, 3) === 8)
  }

  test("10 pow 2 is 100") {
    assert(Exercise10.pow(10, 2) === 100)
  }

  test("5 pow 3 is 125") {
    assert(Exercise10.pow(5, 3) === 125)
  }
}
