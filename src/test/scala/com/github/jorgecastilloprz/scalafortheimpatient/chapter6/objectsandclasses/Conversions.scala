package com.github.jorgecastilloprz.scalafortheimpatient.chapter6.objectsandclasses

/**
 * @author jorge
 * @since 29/05/15
 */
object Conversions {

  /*http://docs.scala-lang.org/style/naming-conventions.html
  Constant names should be in upper camel case.
  That is, if the member is final, immutable and it belongs to a package object or an object, it
  may be considered a constant */
  val InchesToCentimeters = 2.54
  val GallonsToLiters = 3.78541178
  val MilesToKilometers = 1.609344

  def inchesToCentimeters(inches: Int): Double = {
    inches * InchesToCentimeters
  }

  def gallonsToLiters(gallons: Int): Double = {
    gallons * GallonsToLiters
  }

  def milesToKilometers(miles: Int): Double = {
    miles * MilesToKilometers
  }
}
