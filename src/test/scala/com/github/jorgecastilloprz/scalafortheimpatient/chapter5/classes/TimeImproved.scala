package com.github.jorgecastilloprz.scalafortheimpatient.chapter5.classes

/**
 * This time, the internal representation of time has to be the number of minutes since midnight
 * (between 0 and 24x60 - 1). Public interface to the class must not change. That is, client code
 * should be unaffected by the change.
 *
 * @author jorge
 * @since 29/05/15
 */
class TimeImproved(private val hours: Int, private val minutes: Int) {

  val minutesSinceMidnight: Long = hours * 60 + minutes

  def before(other: TimeImproved): Boolean = {
    minutesSinceMidnight < other.minutesSinceMidnight
  }
}