package com.github.jorgecastilloprz.scalafortheimpatient.chapter1

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import scala.math.BigInt.probablePrime
import scala.math._
import scala.util.Random

/**
 * Test suite for chapter 1. You can find my solutions for the 10 exercises given by the book here.
 *
 * @author jorge
 * @since 25/05/15
 */
@RunWith(classOf[JUnitRunner])
class Chapter1TestSuite extends FunSuite {

  /*
  Exercise 1:
  -----------
  *In the Scala REPL, type 3. followed by the Tab key. ¿What methods can be applied?*

  ```
  scala> 3.
  !=   %   *   -   <    <=       ==   >=   >>>   asInstanceOf   getClass   isInstanceOf   toChar
  toFloat   toLong    toString   unary_-   |
  ##   &   +   /   <<   <init>   >    >>   ^     equals         hashCode   toByte         toDouble
  toInt     toShort   unary_+    unary_~
  ```
  That is the result printed when pressing Tab after typing "3.". Everything you can find in the
  print is a method.
  In scala, methods can have any name, so operators like "!=", "*", "<=" are methods too. You could
  add an int to another by doing:

  ```
  scala> 3.+(2)
  res1: Int = 5
  ```

  In `Scala`, primitive types are objects too, so they have plenty of methods that you cannot find
  if you work with the same type in `Java`.
   */

  test("2. The square root of 3 followed by its square is almost 3") {
    assert(3 - squareRootFollowedBySquare(3) <= 0.000000000000001)
  }

  test("2. The square root of 10 followed by its square is almost 15") {
    assert(3 - squareRootFollowedBySquare(15) <= 0.000000000000001)
  }

  def squareRootFollowedBySquare(x: Int): Double = {
    val squareRootValue = sqrt(x)
    val squareValue = pow(squareRootValue, 2)
    squareValue
  }

  /*
  Exercise 3:
  -----------
  * Are the `res` variables val or var?

  `res` variables printed by the REPL are `val`. That means that those variables are immutable.
  You can define your own variables (mutable or immutable) in the REPL by using normal syntax:

  ```
  scala> var myTempVar = 1+1
  myTempVar: Int = 2

  scala> myTempVar = 17
  myTempVar: Int = 17
  ```

  As you declared it as a mutable `var`, you can reassign a new value to it.
   */

  test("4. Multiply word \"crazy\" 3 times gives you a result of: ") {
    assert(multiplyStringNTimes("crazy", 3) === "crazycrazycrazy")
  }

  test("4. Multiply \"hello\" 10 times gives you a result of: ") {
    assert(multiplyStringNTimes("hello", 10)
      === "hellohellohellohellohellohellohellohellohellohello")
  }

  def multiplyStringNTimes(stringToMultiply: String, times: Int): String = {
    stringToMultiply * times
  }

  test("5. Max value between 4 and 543 is 543") {
    assert(obtainMax(4, 543) === 543)
  }

  test("5. Max value between 4 and 43234 is not 4: ") {
    assert(obtainMax(4, 43234) != 4)
  }

  def obtainMax(firstValue: Int, secondValue: Int): Int = {
    firstValue max secondValue
  }

  test("6. Using BigInt 2 elevated to 1024 can be computed an is a REALLY BIG integer.") {
    assert(giveMeThePow(2, 1024).toString() ===
      "17976931348623159077293051907890247336179769789423065727343008115773267580550096313270847" +
        "732240753602112011387987139335765878976881441662249284743063947412437776789342486548527" +
        "630221960124609411945308295208500576883815068234246288147391311054082723716335051068458" +
        "6298239947245938479716304835356329624224137216")
  }

  def giveMeThePow(firstValue: Int, secondValue: Int): BigInt = {
    val firstValueBigInt = BigInt(firstValue)
    firstValueBigInt.pow(secondValue)
  }

  test("7. probablePrime(100, Random) without qualifiers works ok thanks to imports") {
    println("probablePrime(100, Random) working ok thanks to imports: " +
      probablePrime(100, Random))
  }

  test("8. Random generated number is alfanumeric.") {
    val randomFileName = getEncryptedFileDir()
    println("Random filename: " + randomFileName)

    assert(randomFileName.matches("^[a-zA-Z0-9]*$"))
  }

  def getEncryptedFileDir(): String = {
    val randomBigInt = BigInt(200, Random)
    randomBigInt.toString(36) //returns the base 36 of the BigInt number
  }

  test("9. Firt character of word \"Hello\" is 'H'") {
    assert(getFirstCharacterIn("Hello") === 'H')
  }

  test("9. Last character of word \"What\" is 't'") {
    assert(getLastCharacterIn("What") === 't')
  }

  test("9. First character of \"IronMan\" is 'I") {
    assert(getFirstCharacterIn("IronMan") === 'I')
  }

  test("9. Last character of \"IronMan\" is 'n'") {
    assert(getLastCharacterIn("IronMan") === 'n')
  }

  def getFirstCharacterIn(word: String): Char = {
    word(0)
  }

  def getLastCharacterIn(word: String): Char = {
    word(word.length - 1)
  }

  test("10. Taking first 3 chars from \"ScarletWitch\" results in \"Sca\"") {
    assert(takeFirstThreeElementsFrom("ScarletWitch") === "Sca")
  }

  test("10. Dropping first 3 chars from \"ScarletWitch\" results in \"rletWitch\"") {
    assert(dropFirstThreeElementsFrom("ScarletWitch") === "rletWitch")
  }

  test("10. Taking last 3 chars from \"BruceBanner\" results in \"ner\"") {
    assert(takeLastThreeElementsFrom("BruceBanner") === "ner")
  }

  test("10. Dropping last 3 chars from \"BruceBanner\" results in \"BruceBan\"") {
    assert(dropLastThreeElementsFrom("BruceBanner") == "BruceBan")
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
