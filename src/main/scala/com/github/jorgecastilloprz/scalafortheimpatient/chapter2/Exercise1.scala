package com.github.jorgecastilloprz.scalafortheimpatient.chapter2

/**
 * THe signum of a number is 1 if its positive, -1 if its negative and 0 if it is zero. Write a function that computes
 * this value.
 *
 * @author jorge
 * @since 24/05/15
 */
object Exercise1 {

  def main(args: Array[String]): Unit = {
    println("Sign result code for value 429 is " + getResultCodeForNumberSign(429))
    println("Sign result code for value -150926 is " + getResultCodeForNumberSign(-150926))
    println("Sign result code for value 0 is " + getResultCodeForNumberSign(0))
  }

  /**
   * As you can see, the return type is not mandatory if the function is not recursive, as it can be found by scala
   * just by checking the right side of the = symbol.
   * @param num
   * @return
   */
  def getResultCodeForNumberSign(num: Int) = {
    if (num > 0) 1 else if (num < 0) -1 else 0
  }
}