package com.github.jorgecastilloprz.scalafortheimpatient.chapter3

/**
 * How do you compute the average of an Array[Double] ?
 *
 * @author jorge
 * @since 25/05/15
 */
object Exercise5 {

  def main(args: Array[String]) {
    println("Average of Array(2.2, 1.2, 3.6, 5.1, 5.8, 10.99) = " + average(Array(2.2, 1.2, 3.6, 5.1, 5.8, 10.99)))
  }

  def average(doubles: Array[Double]): Double = {
    doubles.sum / doubles.length
  }
}
