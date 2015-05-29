package com.github.jorgecastilloprz.scalafortheimpatient.chapter6.objectsandclasses

/**
 * @author jorge
 * @since 29/05/15
 */
class Point private(val x: Int, val y: Int) {

}

//The class and the companion object must be declared in the same source file.
object Point {
  def apply(x: Int, y: Int) = {
    new Point(x, y)
  }
}
