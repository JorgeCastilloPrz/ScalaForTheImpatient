package com.github.jorgecastilloprz.scalafortheimpatient.chapter1

import scala.BigInt.probablePrime
import scala.util.Random

/**
 * What do you need to import so that you can get a random prime as probablePrime(100, Random), without any qualifiers
 * before probablePrime and Random?
 *
 * @author jorge
 * @since 23/05/15
 */
object Exercise7 {

  def main(args: Array[String]) {
    println("probablePrime(100, Random) without qualifiers works ok thanks to imports and it's result is: " +
      probablePrime(100, Random));
  }
}
