package com.github.jorgecastilloprz.scalafortheimpatient.chapter5.classes

/**
 * @author jorge
 * @since 29/05/15
 */
class Employee(paramName: String = "John Q. Public", paramSalary: Double = 0.0) {
  val name: String = paramName
  var salary: Double = paramSalary
}
