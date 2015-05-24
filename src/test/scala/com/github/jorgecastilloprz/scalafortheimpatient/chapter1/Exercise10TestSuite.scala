package com.github.jorgecastilloprz.scalafortheimpatient.chapter1

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * @author jorge
 * @since 24/05/15
 */
@RunWith(classOf[JUnitRunner])
class Exercise10TestSuite extends FunSuite {

  test("Taking first 3 chars from \"ScarletWitch\" results in \"Sca\"") {
    assert(Exercise10.takeFirstThreeElementsFrom("ScarletWitch") === "Sca")
  }

  test("Dropping first 3 chars from \"ScarletWitch\" results in \"rletWitch\"") {
    assert(Exercise10.dropFirstThreeElementsFrom("ScarletWitch") === "rletWitch")
  }

  test("Taking last 3 chars from \"BruceBanner\" results in \"ner\"") {
    assert(Exercise10.takeLastThreeElementsFrom("BruceBanner") === "ner")
  }

  test("Dropping last 3 chars from \"BruceBanner\" results in \"BruceBan\"") {
    assert(Exercise10.dropLastThreeElementsFrom("BruceBanner") == "BruceBan")
  }
}
