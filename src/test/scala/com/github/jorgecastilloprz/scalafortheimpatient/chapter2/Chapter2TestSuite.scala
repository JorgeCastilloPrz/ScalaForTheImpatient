package com.github.jorgecastilloprz.scalafortheimpatient.chapter2

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * Test suite for chapter 2 from the book. Solutions proposed for all the 10 exercises.
 *
 * @author jorge
 * @since 25/05/15
 */
@RunWith(classOf[JUnitRunner])
class Chapter2TestSuite extends FunSuite {

  /*
  1. The signum of a number is 1 if its positive, -1 if its negative and 0 if it is zero. Write a function that computes
  this value
   */

  test("1. Sign result for number 3431 is 1") {
    assert(getResultCodeForNumberSign(3431) === 1)
  }

  test("1. Sign result for number -9123 is -1") {
    assert(getResultCodeForNumberSign(-9123) === -1)
  }

  test("1. Sign result for 0 is 0") {
    assert(getResultCodeForNumberSign(0) === 0)
  }

  test("1. Sign result for 0 is not 1") {
    assert(getResultCodeForNumberSign(0) != 1)
  }

  test("1. Sign result for 0 is -1") {
    assert(getResultCodeForNumberSign(0) != -1)
  }

  /**
   * As you can see, the return type is not mandatory if the function is not recursive, as it can be found by scala
   * just by checking the right side of the = symbol.
   */
  def getResultCodeForNumberSign(num: Int) = {
    if (num > 0) 1 else if (num < 0) -1 else 0
  }

  /*
  2. What is the value of an empty block expression {}? What is its type?
  The value of a block is the value of the last expression. The value of an empty block is Unit, as Unit is like the
  java void type. The value for Unit is a single one, written as ()
   */

  test("2. Type for empty block \"{}\" is Unit") {
    assert({}.isInstanceOf[Unit])
  }

  test("2. Value for empty block is ()") {
    assert(getValueForEmptyBlock() ===())
  }

  def getValueForEmptyBlock(): Unit = {
    {}
  }

  /*
  3. Come up with one situation where the assignment x = y = 1 is valid in Scala. (Hint: Pick a suitable type for x.)
  The solution is just to know that in Scala, the value of an assignment is of type Unit. If an assignment is the
  last expression of a block, the value of that block is Unit.
   */

  test("3. Assign is of type Unit") {
    assert(checkIfDoubleAssignIsUnit())
  }

  def checkIfDoubleAssignIsUnit(): Boolean = {
    var temp: Unit = 0
    var temp2 = 1
    (temp = temp2 = 1).isInstanceOf[Unit]
  }

  /*
  4. Write a Scala equivalent for the Java loop: for (int i = 10; i >= 0; i--) System.out.println(i);
  There are plenty of ways to do this loop, but i solved it just by using method "to" from RichInt to generate a Range
  and then reverse it. You can loop over that final sequence with a simple for.
   */

  test("4. Inverse loop values: ") {
    printValuesForInverseLoop()
  }

  def printValuesForInverseLoop() {
    val inverseLoop = for (x <- (0 to 10).reverse) yield x
    println("InverseLoop: " + inverseLoop.mkString(" "))
  }

  /*
   5. Write a procedure countdown(n: Int) that prints the numbers from n to 0.
   */

  test("5. countdown procedure: ") {
    countdown(10)
  }

  def countdown(topNumber: Int) {
    print("Countdown: ")
    for (num <- 0 to topNumber reverse) print(num + " ")
  }

  /*
  6. Write a for loop for computing the product of the Unicode codes of all letters in a string. For example, the product
  of the characters in "Hello" is 9415087488L.
   */

  test("6. Product of unicode values of every character in \"Hello\" is equals to 9415087488L") {
    assert(calculateUnicodeProductOfLetters("Hello") === 9415087488L)
  }

  def calculateUnicodeProductOfLetters(word: String): Long = {
    var totalProduct: Long = 1
    for (c <- word) totalProduct *= c.toInt
    totalProduct
  }

  /*
  7. Solve exercise6 without writting a loop.
  Compute the product of the Unicode codes of all letters in a string. For example, the product
  of the characters in "Hello" is 9415087488L.
   */

  test("7. Product of unicode values of every character in \"Hello\" is equals to 9415087488L") {
    assert(calculateUnicodeProductOfLettersWithoutLoop("Hello") === 9415087488L)
  }

  def calculateUnicodeProductOfLettersWithoutLoop(word: String): Long = {
    word.foldLeft(1L)(_ * _.toInt)
  }

  /*
   8. Write a function product(s: String) that computes the product, as described in the preceding exercises.
   - As i did the last 2 exercises by creating a function with 2 different solutions, this one is not necessary anymore.
   */

  /*
   9. Make the function of the preceding exercise a recursive function. (The function that calculates the product of all
   the character unicode values from a string).
    */

  test("9. Product of unicode values of every character in \"Hello\" is equals to 9415087488L") {
    assert(calculateUnicodeProductOfLetters("Hello", 0) === 9415087488L)
  }

  def calculateUnicodeProductOfLetters(word: String, currentCharPos: Int): Long = {
    if (currentCharPos <= word.length - 1)
      word(currentCharPos) * calculateUnicodeProductOfLetters(word, currentCharPos + 1)
    else 1
  }

  /*
  10. Write a function that computes x pow n where n is a integer. Use the following recursive definition:
  x pow n = y pow 2 , if n is even and positive, where y = x pow n/2
  x pow n = x * x pow n-1 , if n is odd and positive
  x pow 0 = 1
  x pow n = 1 / (x pow -n) , if n is negative

  Don't use return statement
   */

  test("2 pow 3 is 8") {
    assert(pow(2, 3) === 8)
  }

  test("10 pow 2 is 100") {
    assert(pow(10, 2) === 100)
  }

  test("5 pow 3 is 125") {
    assert(pow(5, 3) === 125)
  }

  def pow(x: Int, n: Int): Long = {
    val res = if (n == 0) 1
    else
    if (n < 0) 1 / (x * pow(x, n - 1))
    else if (n % 2 != 0) x * pow(x, n - 1)
    else pow(x, n / 2) * pow(x, n / 2)

    res
  }
}
