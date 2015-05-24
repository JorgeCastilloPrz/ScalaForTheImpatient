package com.github.jorgecastilloprz.scalafortheimpatient.chapter1

/**
 * Using BigInt compute 2 elevated to 1024
 *
 * @author jorge
 * @since 23/05/15
 */
object Exercise6 {

  def main(args: Array[String]) {
    println("Using BigInt, 2 elevated to 1024 returns: " + giveMeThePow(2, 1024));
  }

  def giveMeThePow(firstValue: Int, secondValue: Int): BigInt = {
    val firstValueBigInt = BigInt(firstValue);
    firstValueBigInt.pow(secondValue)
  }
}