package com.github.jorgecastilloprz.scalafortheimpatient.chapter2

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * @author jorge
 * @since 24/05/15
 */
@RunWith(classOf[JUnitRunner])
class Exercise6TestSuite extends FunSuite {

  test("Product of unicode values of every character in \"Hello\" is equals to 9415087488L") {
    assert(Exercise6.calculateUnicodeProductOfLetters("Hello") === 9415087488L)
  }
}