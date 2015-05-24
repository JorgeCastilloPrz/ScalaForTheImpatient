package com.github.jorgecastilloprz.scalafortheimpatient.chapter1

/**
 * How do you get the first character of a string in Scala? And the last one?
 *
 * @author jorge
 * @since 24/05/15
 */
object Exercise9 {

  def main(args: Array[String]) {
    println("")
  }

  def getFirstCharacterIn(word: String): Char = {
    word(0)
  }

  def getLastCharacterIn(word: String): Char = {
    word(word.length - 1)
  }
}
