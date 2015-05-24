package com.github.jorgecastilloprz.scalafortheimpatient.chapter2

/**
 * Write a for loop for computing the product of the Unicode codes of all letters in a string. For example, the product
 * of the characters in "Hello" is 9415087488L.
 *
 * @author jorge
 * @since 24/05/15
 */
object Exercise6 {

  def main(args: Array[String]) {
    println(calculateUnicodeProductOfLetters("Hello"))
  }

  def calculateUnicodeProductOfLetters(word: String): Long = {
    var totalProduct: Long = 1
    for (c <- word) totalProduct *= c.toInt
    totalProduct
  }
}
