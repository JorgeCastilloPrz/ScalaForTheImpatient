package com.github.jorgecastilloprz.scalafortheimpatient.chapter5.classes

/**
 * @author jorge
 * @since 29/05/15
 */
class Time(private val hours: Int, private val minutes: Int) {

  def before(other: Time): Boolean = {
    if (hours > other.hours) false else if (hours < other.hours) true else minutes < other.minutes
  }
}
