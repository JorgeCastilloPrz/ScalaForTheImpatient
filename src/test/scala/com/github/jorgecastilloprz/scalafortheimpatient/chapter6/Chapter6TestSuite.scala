package com.github.jorgecastilloprz.scalafortheimpatient.chapter6

import com.github.jorgecastilloprz.scalafortheimpatient.chapter6.objectsandclasses._
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * @author jorge
 * @since 29/05/15
 */
@RunWith(classOf[JUnitRunner])
class Chapter6TestSuite extends FunSuite {

  test("1. Write an object Conversions with methods inchesToCentimeters, gallonsToLiters, " +
    "and milesToKilometers") {

    assert(Conversions.inchesToCentimeters(100) === 100 * 2.54)
    assert(Conversions.gallonsToLiters(10) === 10 * 3.78541178)
    assert(Conversions.milesToKilometers(25) === 25 * 1.609344)
  }

  test("2. The preceding problem was not very object-oriented. Provide a general superclass " +
    "UnitConversion and define objects InchesToCentimeters, GallosToLiters, and " +
    "MilesToKilometers that extend it.") {

    assert(InchesToCentimeters.convert(100) === 100 * 2.54)
    assert(GallonsToLiters.convert(10) === 10 * 3.78541178)
    assert(MilesToKilometers.convert(25) === 25 * 1.609344)
  }

  test("3. Define an Origin object that extends java.awt.Point. Why is this not actually a good " +
    "idea? (Have a close look at the methods of the Point class.)") {

    /* The Point class is not created to be used as a singleton. Instead of that, it should
     represent a Point with its very own x, y coordinates, and it should be able to get
     instantiated as many times as the developer needs, with different coordinates. In Scala,
     objects exist to allow singleton pattern and to work as Factories or handle utility
     functions, mainly. */
  }

  test("4. Define a Point class with a companion object so that you can construct Point " +
    "instances as Point(3, 4), without using new") {

    val point1 = Point(2, 3)
    val point2 = Point(3, 4)

    assert(point2.x === 3 && point2.y === 4)
  }

  test("5. Write a Scala application, using the App trait, that prints the command-line " +
    "arguments in a reverse order, separated by spaces. For example, scala Reverse Hello World " +
    "should print World Hello") {

    Reverse.main(Array("Hello", "World"))
  }

  test("6. Write an enumeration describing the four playing card suits so that the toString " +
    "method returns spades, hearts, diamonds, or clubs icons (in ascii icon chars)") {

    println(CardSuit.Spades + " " + CardSuit.Hearts + " " + CardSuit.Diamonds + " " +
      CardSuit.Clubs)
  }

  test("7. Implement a function that checks whether a card suit value from the preceding " +
    "exercise is red.") {

    assert(CardSuit.isARedSuit(CardSuit.Hearts))
    assert(CardSuit.isARedSuit(CardSuit.Diamonds))
    assert(!CardSuit.isARedSuit(CardSuit.Spades))
    assert(!CardSuit.isARedSuit(CardSuit.Clubs))

    /* I defined the utility method into the CardSuit object, as objects are useful to handle
     * that sort of methods too. */
  }

  test("8. Write an enumeration describing the eight corners of the RGB color cube. As IDs, use " +
    "the color values (for example, 0xff0000 for Red).") {

    assert(RGBCornerColor.Red.toString === "Red" && RGBCornerColor.Red.id === 0xFF0000)
    assert(RGBCornerColor.Green.toString === "Green" && RGBCornerColor.Green.id === 0x00FF00)
    assert(RGBCornerColor.Blue.toString === "Blue" && RGBCornerColor.Blue.id === 0x0000FF)
    assert(RGBCornerColor.Cyan.toString === "Cyan" && RGBCornerColor.Cyan.id === 0xFFFF00)
    assert(RGBCornerColor.Magenta.toString === "Magenta" && RGBCornerColor.Magenta.id === 0xFF00FF)
    assert(RGBCornerColor.Yellow.toString === "Yellow" && RGBCornerColor.Yellow.id === 0x00FFFF)
  }
}
