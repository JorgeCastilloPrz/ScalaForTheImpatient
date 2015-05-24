package com.github.jorgecastilloprz.scalafortheimpatient.chapter1

/**
 * What do the take, drop, takeRight, and dropRight string functions do? What advantage and disadvantage do they have
 * over using substring?
 *
 * take: Takes first N elements from given argument
 * drop: Drops first N elements from the given arg
 * takeRight: Takes last N elems from the arg
 * dropRight: Drops last N elements from the given arg
 *
 * The main difference over substring method is that substring makes an implicit conversion from StringOps to the basic
 * String class from Java. (Scala uses java Strings as a base, but it adds them a lot of new functionality through the
 * StringOps class.
 *
 * @author jorge
 * @since 24/05/15
 */
object Exercise10 {

  def main(args: Array[String]) {
    println("First three chars from \"Hawkeye\" are: " + "Hawkeye".take(3))
    println("If we drop first 3 characters from \"IronMan\", we get: " + "IronMan".drop(3))
    println("If we take the last 3 characters from \"Hulk\" we get: " + "Hulk".takeRight(3))
    println("If drop the last 3 characters from \"ScarletWitch\", we get: " + "ScarletWitch".dropRight(3))
  }

  def takeFirstThreeElementsFrom(word: String): String = {
    word.take(3)
  }

  def dropFirstThreeElementsFrom(word: String): String = {
    word.drop(3)
  }

  def takeLastThreeElementsFrom(word: String): String = {
    word.takeRight(3)
  }

  def dropLastThreeElementsFrom(word: String): String = {
    word.dropRight(3)
  }
}