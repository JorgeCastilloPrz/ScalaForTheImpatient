package com.github.jorgecastilloprz.scalafortheimpatient.chapter6.objectsandclasses

/**
 * @author jorge
 * @since 29/05/15
 */
object InchesToCentimeters extends AbstractConversion {

  val InchesToCentimeters = 2.54

  override def convert(value: Int): Double = {
    value * InchesToCentimeters
  }
}
