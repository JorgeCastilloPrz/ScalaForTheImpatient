package com.github.jorgecastilloprz.scalafortheimpatient.chapter2

/**
 * Come up with one situation where the assignment x = y = 1 is valid in Scala. (Hint: Pick a suitable type for x.)
 *
 * The solution is just to know that in Scala, the value of an assignment is of type Unit. If an assignment is the
 * last expression of a block, the value of that block is Unit.
 *
 * @author jorge
 * @since 24/05/15
 */
object Exercise3 {

  def main(args: Array[String]): Unit = {
    var s: Int = 1
    println("Value for an assignment is of type Unit: " + (s = 2).isInstanceOf[Unit])
  }

  def checkIfDoubleAssignIsUnit(): Boolean = {
    var temp: Unit = 0
    var temp2 = 1
    (temp = temp2 = 1).isInstanceOf[Unit]
  }
}
