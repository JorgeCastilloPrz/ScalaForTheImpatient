package com.github.jorgecastilloprz.scalafortheimpatient.chapter5.classes

/**
 * @author jorge
 * @since 29/05/15
 */
class PersonImproved(nameAndLastName: String) {
  val firstName = nameAndLastName.split(" ")(0)
  val lastName = nameAndLastName.split(" ")(1)
}