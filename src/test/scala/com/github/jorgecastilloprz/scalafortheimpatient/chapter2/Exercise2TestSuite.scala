package com.github.jorgecastilloprz.scalafortheimpatient.chapter2

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * @author jorge
 * @since 24/05/15
 */
@RunWith(classOf[JUnitRunner])
class Exercise2TestSuite extends FunSuite {

  test("Type for empty block \"{}\" is Unit") {
    assert({}.isInstanceOf[Unit])
  }

  test("Value for empty block is ()") {
    assert({} === ())
  }
}
