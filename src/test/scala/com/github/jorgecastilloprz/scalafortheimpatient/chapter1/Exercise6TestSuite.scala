package com.github.jorgecastilloprz.scalafortheimpatient.chapter1

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * @author jorge
 * @since 23/05/15
 */
@RunWith(classOf[JUnitRunner])
class Exercise6TestSuite extends FunSuite {

  test("Using BigInt 2 elevated to 1024 can be computed an is a REALLY BIG integer.") {
    assert(Exercise6.giveMeThePow(2, 1024).toString() === "179769313486231590772930519078902473361797697894230657273430081157732675805500963132708477322407536021120113879871393357658789768814416622492847430639474124377767893424865485276302219601246094119453082952085005768838150682342462881473913110540827237163350510684586298239947245938479716304835356329624224137216")
  }
}
