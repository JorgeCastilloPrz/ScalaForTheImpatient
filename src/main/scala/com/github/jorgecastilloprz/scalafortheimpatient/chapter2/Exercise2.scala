package com.github.jorgecastilloprz.scalafortheimpatient.chapter2

/**
 * What is the value of an empty block expression {}? What is its type?
 *
 * The value of a block is the value of the last expression. The value of an empty block is Unit, as Unit is like the
 * java void type.
 *
 * The value for Unit is a single one, written as ()
 *
 * @author jorge
 * @since 24/05/15
 */
object Exercise2 {

  def main(args: Array[String]) {
    println("The type of an empty block \"{}\" is Unit, and its value is: " + {})
  }

  def getValueForEmptyBlock(): String = {
    {}.toString
  }
}
