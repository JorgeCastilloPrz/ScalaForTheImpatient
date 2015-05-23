package com.github.jorgecastilloprz.scalafortheimpatient.chapter1

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * @author jorge
 * @since 23/05/15
 */
@RunWith(classOf[JUnitRunner])
class Exercise5TestSuite extends FunSuite {

  test("Max value between 4 and 543 is 543") {
    assert(Exercise5.obtainMax(4, 543) === 543)
  }

  test("Max value between 4 and 43234 is not 4: ") {
    assert(Exercise5.obtainMax(4, 43234) != 4)
  }
}
