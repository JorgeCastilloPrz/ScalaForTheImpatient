package com.github.jorgecastilloprz.scalafortheimpatient.chapter5

import com.github.jorgecastilloprz.scalafortheimpatient.chapter5.classes._
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * @author jorge
 * @since 29/05/15
 */
@RunWith(classOf[JUnitRunner])
class Chapter5TestSuite extends FunSuite {

  test("1. Improve the Counter class in Section 5.1, on page 49 so that it doesn't turn negative " +
    "at Int.MaxValue") {

    val basicCounter: Counter = new Counter
    basicCounter.setToIntMaxValue()
    println("Counter at Int max value: " + basicCounter.current)
    basicCounter.increment()
    println("Counter after incrementing Int max value: " + basicCounter.current)

    assert(basicCounter.current < 0)

    val bigIntCounter: CounterImproved = new CounterImproved
    bigIntCounter.setToIntMaxValue()
    println("ImprovedCounter at Int max value: " + bigIntCounter.current)
    bigIntCounter.increment()
    println("ImprovedCounter after incrementing Int max value: " + bigIntCounter.current)

    assert(bigIntCounter.current > 0)
  }

  test("2. Write a class BankAccount with methods deposit and withdraw, and a read-only property " +
    "balance.") {

    val bankAccount = new BankAccount
    bankAccount.deposit(1250.99)
    assert(bankAccount.getCurrentMoney === 1250.99)
    bankAccount.withdraw(95)
    assert(bankAccount.getCurrentMoney === (1250.99 - 95))
  }

  test("3. Write a class Time with read-only properties hours and minutes and a method " +
    "before(other: Time): Boolean that checks whether this time comes before the other. A Time " +
    "object should be constructed as new Time(hrs, min), where hrs is in military time format " +
    "(between 0 and 23).") {

    val firstTime = new Time(12, 55)
    val secondTime = new Time(16, 20)

    assert(firstTime.before(secondTime))
    assert(!secondTime.before(firstTime))
  }

  test("4. Reimplement the Time class from the preceding exercise so that the internal " +
    "representation is the number of minutes since midnight (between 0 and 24x60 - 1). Do not " +
    "change the public interface. That is, client code should be unaffected by your change.") {

    val firstTime = new Time(12, 55)
    val secondTime = new Time(16, 20)

    assert(firstTime.before(secondTime))
    assert(!secondTime.before(firstTime))
  }

  test("5. Make class Student with read-write JavaBeans properties name (of type String) and id " +
    "(of type Long). What methods are generated? (Use javap to check.) Can you call JavaBeans " +
    "getters and setters in Scala? Should you?") {

    val student1 = new Student("Pepico Berbenas", 1)
    val student2 = new Student("Fernando Alonso", 2)
    val student3 = new Student("Tony Stark", 3)

    assert(student1.id === 1 && student1.name === "Pepico Berbenas")
    assert(student2.id === 2 && student2.name === "Fernando Alonso")
    assert(student3.id === 3 && student3.name === "Tony Stark")

    assert(student1.getId === 1 && student1.getName === "Pepico Berbenas")
    assert(student2.getId === 2 && student2.getName === "Fernando Alonso")
    assert(student3.getId === 3 && student3.getName === "Tony Stark")

    /*As the properties are defined as val, just both getter methods are generated (the scala and
    * the java ones). If the fields would have been defined as vars, we would get all the four
    * methods generated for each field:
    *
    * name:String
    * name_=(newValue: String): Unit (scala setter)
    * getName():String
    * setName(newValue: String): Unit
    *
    * For the Id field we would get the same four methods.
    *
    * You should use JavaBeans methods just when you have not the chance to use the scala ones.
    * They may be useful if you have to work with a java lib that needs your entities to provide
    * standard java getter/setter implementation.
    * */
  }

  test("6. "){}
}
