package com.github.jorgecastilloprz.scalafortheimpatient.chapter2

/**
 * Make the function of the preceding exercise a recursive function. (The function that calculates the product of all
 * the character unicode values from a string).
 *
 * @author jorge
 * @since 24/05/15
 */
object Exercise9 {

  def main(args: Array[String]) {
    println(calculateUnicodeProductOfLetters("Hello", 0))
  }

  def calculateUnicodeProductOfLetters(word: String, currentCharPos: Int): Long = {
    if (currentCharPos <= word.length - 1)
      word(currentCharPos) * calculateUnicodeProductOfLetters(word, currentCharPos + 1)
    else 1
  }
}