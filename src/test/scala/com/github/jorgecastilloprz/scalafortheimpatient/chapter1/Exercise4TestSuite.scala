package com.github.jorgecastilloprz.scalafortheimpatient.chapter1

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * @author jorge
 * @since 23/05/15
 */
@RunWith(classOf[JUnitRunner])
class Exercise4TestSuite extends FunSuite {

  test("Multiply word \"crazy\" 3 times gives you a result of: ") {
    assert(Exercise4.multiplyStringNTimes("crazy", 3) === "crazycrazycrazy")
  }

  test("Multiply \"hello\" 10 times gives you a result of: ") {
    assert(Exercise4.multiplyStringNTimes("hello", 10) === "hellohellohellohellohellohellohellohellohellohello")
  }
}
