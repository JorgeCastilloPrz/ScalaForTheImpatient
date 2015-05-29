package com.github.jorgecastilloprz.scalafortheimpatient.chapter6.objectsandclasses

/**
 * @author jorge
 * @since 29/05/15
 */
object CardSuit extends Enumeration {

  val Spades = Value("♠")
  val Hearts = Value("♥")
  val Diamonds = Value("♦")
  val Clubs = Value("♣")

  def isARedSuit(suit: CardSuit.Value): Boolean = {
    suit.id == 1 || suit.id == 2
  }
}
