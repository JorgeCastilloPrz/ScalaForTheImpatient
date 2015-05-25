package com.github.jorgecastilloprz.scalafortheimpatient.chapter3

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * @author jorge
 * @since 25/05/15
 */
@RunWith(classOf[JUnitRunner])
class Exercise5TestSuite extends FunSuite {

  test("Average of Array(2.2, 1.2, 3.6, 5.1, 5.8, 10.99) = 4.815") {
    assert(Exercise5.average(Array(2.2, 1.2, 3.6, 5.1, 5.8, 10.99)) === 4.815)
  }
}
