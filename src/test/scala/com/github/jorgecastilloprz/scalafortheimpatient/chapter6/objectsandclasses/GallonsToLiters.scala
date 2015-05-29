package com.github.jorgecastilloprz.scalafortheimpatient.chapter6.objectsandclasses

/**
 * @author jorge
 * @since 29/05/15
 */
object GallonsToLiters extends AbstractConversion {

  val GallonsToLiters = 3.78541178

  override def convert(value: Int): Double = {
    value * GallonsToLiters
  }
}
