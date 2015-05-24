package com.github.jorgecastilloprz.scalafortheimpatient.chapter2

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * @author jorge
 * @since 24/05/15
 */
@RunWith(classOf[JUnitRunner])
class Exercise1TestSuite extends FunSuite {

  test("Sign result for number 3431 is 1") {
    assert(Exercise1.getResultCodeForNumberSign(3431) === 1)
  }

  test("Sign result for number -9123 is -1") {
    assert(Exercise1.getResultCodeForNumberSign(-9123) === -1)
  }

  test("Sign result for 0 is 0") {
    assert(Exercise1.getResultCodeForNumberSign(0) === 0)
  }

  test("Sign result for 0 is not 1") {
    assert(Exercise1.getResultCodeForNumberSign(0) != 1)
  }

  test("Sign result for 0 is -1") {
    assert(Exercise1.getResultCodeForNumberSign(0) != -1)
  }
}
