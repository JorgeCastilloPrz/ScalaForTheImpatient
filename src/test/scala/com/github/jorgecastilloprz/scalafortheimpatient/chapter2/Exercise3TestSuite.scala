package com.github.jorgecastilloprz.scalafortheimpatient.chapter2

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * @author jorge
 * @since 24/05/15
 */
@RunWith(classOf[JUnitRunner])
class Exercise3TestSuite extends FunSuite {

  test("Assign is of type Unit") {
    assert(Exercise3.checkIfDoubleAssignIsUnit())
  }
}
