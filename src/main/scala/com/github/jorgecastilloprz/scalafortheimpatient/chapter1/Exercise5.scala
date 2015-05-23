package com.github.jorgecastilloprz.scalafortheimpatient.chapter1

/**
 * What does 10 max 2 mean? In which class is the max method defined?
 *
 * if you check ScalaDoc, you can find the max method defined in the Int class. It returns the higher value between
 * this (the int caller) and the argument passed. So 2 max 10 (or 2.max(10)) would be 10.
 *
 * @author jorge
 * @since 23/05/15
 */
object Exercise5 {

  def main(args: Array[String]) {
    println("Max value between 2 and 10 is: " + obtainMax(2, 10));
  }

  def obtainMax(firstValue: Int, secondValue: Int): Int = {
    firstValue max secondValue
  }
}
