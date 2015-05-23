package com.github.jorgecastilloprz.scalafortheimpatient.chapter1

/**
 * Scala lets you multiply a string with a number. Try out "crazy" * 3 in the REPL. What does this operation do? Where
 * can you find it in Scaladoc?
 *
 * (You can find '*' method in StringOps class defined in ScalaDoc. StringOps provides basic Strings with plenty of
 * additional functionality).
 *
 * @author jorge
 * @since 23/05/15
 */
object Exercise4 {

  def main(args: Array[String]) {
    println("Multiply the string \"crazy\" 3 times results in: " + multiplyStringNTimes("crazy", 3));
  }

  def multiplyStringNTimes(stringToMultiply: String, times: Int): String = {
    stringToMultiply * times;
  }
}
