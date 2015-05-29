package com.github.jorgecastilloprz.scalafortheimpatient.chapter5.classes

/**
 * @author jorge
 * @since 29/05/15
 */
class Counter {

  private var value = 0

  def increment() {
    value += 1
  }

  def setToIntMaxValue(): Unit = {
    value = Int.MaxValue
  }

  def current = value
}
