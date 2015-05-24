package com.github.jorgecastilloprz.scalafortheimpatient.chapter1

import scala.util.Random

/**
 * One way to create random file or directory names is to produce a random BigInt and convert it to base 36, yielding
 * a string such as "qsnvbevtomcj38o06kul". Poke around Scaladoc to find a way of doing this in Scala.
 *
 * @author jorge
 * @since 23/05/15
 */
object Exercise8 {

  def main(args: Array[String]) {

    println("Random encrypted file directory: " + getEncryptedFileDir())
  }

  def getEncryptedFileDir(): String = {
    val randomBigInt = BigInt(200, Random);
    randomBigInt.toString(36) //returns the base 36 of the BigInt number
  }
}