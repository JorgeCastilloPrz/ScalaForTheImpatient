package com.github.jorgecastilloprz.scalafortheimpatient.chapter1

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * @author jorge
 * @since 24/05/15
 */
@RunWith(classOf[JUnitRunner])
class Exercise8TestSuite extends FunSuite {

  test("Random generated number is alfanumeric.") {
    val randomFileName = Exercise8.getEncryptedFileDir()
    println("Random filename: " + randomFileName)

    assert(randomFileName.matches("^[a-zA-Z0-9]*$"))
  }
}
