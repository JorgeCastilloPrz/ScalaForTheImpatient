package com.github.jorgecastilloprz.scalafortheimpatient.chapter2

/**
 * Write a procedure countdown(n: Int) that prints the numbers from n to 0.
 *
 * @author jorge
 * @since 24/05/15
 */
object Exercise5 {

  def main(args: Array[String]): Unit = {
    countdown(10)
  }

  def countdown(topNumber: Int) {
    for (num <- 0 to topNumber reverse) print(num + " ")
  }
}
