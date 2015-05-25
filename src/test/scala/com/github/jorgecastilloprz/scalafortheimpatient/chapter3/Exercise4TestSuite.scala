package com.github.jorgecastilloprz.scalafortheimpatient.chapter3

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * @author jorge
 * @since 25/05/15
 */
@RunWith(classOf[JUnitRunner])
class Exercise4TestSuite extends FunSuite {

  test("Reordering Array(10, -20, 23, 93, 5, -2, 10, 0, 3, -903) as the question is asking results in " +
    "Array(10, 23, 93, 5, 10, 3, -20, -2, 0, -903)") {

    assert(Exercise4.getReorderedArray(Array(10, -20, 23, 93, 5, -2, 10, 0, 3, -903)) ===
      Array(10, 23, 93, 5, 10, 3, -20, -2, 0, -903))
  }
}
