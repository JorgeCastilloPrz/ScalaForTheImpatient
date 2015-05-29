package com.github.jorgecastilloprz.scalafortheimpatient.chapter5.classes

/**
 * As i cannot use a val (read only) as it needs to be updated, the way to get a read only
 * (from outer classes) variable is to declare it as a private var, and provide methods to
 * update it. Then, i add a method to get its current value from the outside. The client classes
 * cannot set balance at will, but they can update it by depositing or withdraw money.
 *
 * @author jorge
 * @since 29/05/15
 */
class BankAccount {

  private var balance = 0.0

  def deposit(quantity: Double) {
    balance += quantity
  }

  def withdraw(quantity: Double) {
    if (quantity <= balance) balance -= quantity;
  }

  def getCurrentMoney = balance
}
