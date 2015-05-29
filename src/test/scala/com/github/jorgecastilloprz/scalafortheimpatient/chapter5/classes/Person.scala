package com.github.jorgecastilloprz.scalafortheimpatient.chapter5.classes

/**
 * @author jorge
 * @since 29/05/15
 */
class Person(var age: Int) {
  age = if (age < 0) 0 else age
}
