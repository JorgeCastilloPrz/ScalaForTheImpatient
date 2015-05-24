package com.github.jorgecastilloprz.scalafortheimpatient.chapter1

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * @author jorge
 * @since 24/05/15
 */
@RunWith(classOf[JUnitRunner])
class Exercise9TestSuite extends FunSuite {

  test("Firt character of word \"Hello\" is 'H'") {
    assert(Exercise9.getFirstCharacterIn("Hello") === 'H')
  }

  test("Last character of word \"What\" is 't'") {
    assert(Exercise9.getLastCharacterIn("What") === 't')
  }

  test("First character of \"IronMan\" is 'I") {
    assert(Exercise9.getFirstCharacterIn("IronMan") === 'I')
  }

  test("Last character of \"IronMan\" is 'n'") {
    assert(Exercise9.getLastCharacterIn("IronMan") === 'n')
  }
}
