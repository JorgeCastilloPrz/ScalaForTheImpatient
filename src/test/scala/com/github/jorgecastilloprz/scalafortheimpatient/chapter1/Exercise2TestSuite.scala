package com.github.jorgecastilloprz.scalafortheimpatient.chapter1

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * @author jorge
 * @since 23/05/15
 */
@RunWith(classOf[JUnitRunner])
class Exercise2TestSuite extends FunSuite {

  test("The square root of 3 followed by its square is almost 3") {
    assert(3 - Exercise2.squareRootFollowedBySquare(3) <= 0.000000000000001)
  }

  test("The square root of 10 followed by its square is almost 15") {
    assert(3 - Exercise2.squareRootFollowedBySquare(15) <= 0.000000000000001)
  }
}