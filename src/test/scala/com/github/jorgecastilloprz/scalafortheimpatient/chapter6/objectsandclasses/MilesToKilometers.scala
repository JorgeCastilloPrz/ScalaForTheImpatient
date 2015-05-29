package com.github.jorgecastilloprz.scalafortheimpatient.chapter6.objectsandclasses

/**
 * @author jorge
 * @since 29/05/15
 */
object MilesToKilometers extends AbstractConversion {

  val MilesToKilometers = 1.609344

  override def convert(value: Int): Double = {
    value * MilesToKilometers
  }
}
