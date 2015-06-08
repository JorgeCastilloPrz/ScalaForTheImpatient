package com.github.jorgecastilloprz.scalafortheimpatient.chapter8

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * @author jorge
 * @since 8/06/15
 */
@RunWith(classOf[JUnitRunner])
class Chapter8TestSuite extends FunSuite {

  test("1. Extend the following BankAccount class to a CheckingAccount class that charges $1 " +
    "for every deposit and withdrawal." +
    "" +
    "class BankAccount(initialBalance: Double) {" +
    "   private var balance = initialBalance" +
    "   def currentBalance = balance" +
    "   def deposit(amount: Double) = { balance += amount; balance }" +
    "   def withdraw(amount: Double) = { balance -= amount; balance }" +
    "}") {

    val bankAccount = new BankAccount(1000)
    val checkingAccount = new CheckingAccount(1000)

    bankAccount.deposit(500)
    bankAccount.withdraw(500)

    assert(bankAccount.currentBalance === 1000)

    checkingAccount.deposit(500)
    checkingAccount.withdraw(500)

    assert(checkingAccount.currentBalance === 998)
  }

  class BankAccount(initialBalance: Double) {
    private var balance = initialBalance

    def currentBalance = balance

    def deposit(amount: Double) = {
      balance += amount
      balance
    }

    def withdraw(amount: Double) = {
      balance -= amount
      balance
    }
  }

  class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {

    override def deposit(amount: Double) = {
      super.deposit(amount - 1)
    }

    override def withdraw(amount: Double) = {
      super.withdraw(amount + 1)
    }
  }


  test("2. Extend the BankAccount class of the preceding exercise into a class SavingsAccount " +
    "that earns interest every month (when a method earnMonthlyInterest is called) and has three" +
    "free deposits or withdrawals every month. Reset the transaction count in the " +
    "earnMonthlyInterest method.") {

    //This account has earnings of a three percent of the total balance every month
    val threePercentAccount = new SavingsAccount(1000, 3, 0.03)
    threePercentAccount.withdraw(150)
    threePercentAccount.withdraw(150)
    threePercentAccount.deposit(300)

    assert(threePercentAccount.currentBalance === 1000)

    //The limit has been reached so 1 dollar will be charged to the next transactions until the
    //monthly interest is earned.
    threePercentAccount.deposit(10)
    threePercentAccount.deposit(10)

    assert(threePercentAccount.currentBalance === 1018)

    threePercentAccount.earnMonthlyInterest()
    assert(threePercentAccount.currentBalance === 1018 + (1018 * 0.03))

    //Now we have three more transactions, so the next one will not get the 1 dollar charge
    threePercentAccount.withdraw(10)
    assert(threePercentAccount.currentBalance === 1018 + (1018 * 0.03) - 10)
  }

  /**
   * This solution charges 1$ to the account owner when there are not free transactions available
   * any more.
   */
  class SavingsAccount(initialBalance: Double,
                       val transactionLimit: Int = 3,
                       val MonthlyInterestEarning: Double) extends BankAccount(initialBalance) {

    var transactionsThisMonth = 0

    override def deposit(amount: Double) = {
      if (areFreeTransactionsAvailable()) {
        transactionsThisMonth += 1
        super.deposit(amount)
      }
      else super.deposit(amount - 1)
    }

    override def withdraw(amount: Double) = {
      if (areFreeTransactionsAvailable()) {
        transactionsThisMonth += 1
        super.withdraw(amount)
      }
      else super.withdraw(amount - 1)
    }

    def areFreeTransactionsAvailable(): Boolean = {
      transactionsThisMonth < transactionLimit
    }

    def earnMonthlyInterest() = {
      transactionsThisMonth = 0
      super.deposit(currentBalance * MonthlyInterestEarning)
    }
  }

  test("3. Consult your favorite Java or C++ textbook that is sure to have an example of a " +
    "toy inheritance hierarchy, perhaps involing employees, pets, graphical shapes, or the " +
    "like. Implement the example in Scala.") {

    
  }
}
