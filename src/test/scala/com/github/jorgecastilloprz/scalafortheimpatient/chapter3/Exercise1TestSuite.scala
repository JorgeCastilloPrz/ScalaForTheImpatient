package com.github.jorgecastilloprz.scalafortheimpatient.chapter3

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * @author jorge
 * @since 25/05/15
 */
@RunWith(classOf[JUnitRunner])
class Exercise1TestSuite extends FunSuite {

  test("Generated Array has n elements") {
    val a = Exercise1.createArrayOfRandomInts(10)
    assert(a.size === 10)
  }

  test("Generated Array has n random elements between 0 and n-1") {
    val a = Exercise1.createArrayOfRandomInts(5)
    for (randomNum <- a) assert(randomNum >= 0 && randomNum < 5)
  }
}
