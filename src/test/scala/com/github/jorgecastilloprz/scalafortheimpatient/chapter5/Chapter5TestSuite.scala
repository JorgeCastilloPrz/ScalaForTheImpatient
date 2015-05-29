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

  test("6. In the Person class of Section 5.1, on page 49, provide a primary constructor that " +
    "turns negative ages to 0") {

    val person1 = new Person(-30)
    val person2 = new Person(45)
    val person3 = new Person(-1)

    assert(person1.age === 0)
    assert(person2.age === 45)
    assert(person3.age === 0)
  }

  test("7. Write a class Person with a primary constructor that accepts a string containing " +
    "a first name, a space, and a last name, such as new Person(\"Fred Smith\". Supply read-only " +
    "properties firstName and lastName. Should the primary constructor parameter be a var, a " +
    "val, or a plain parameter? Why?") {

    val person1 = new PersonImproved("Fernando Alonso")
    val person2 = new PersonImproved("Bruce Banner")

    assert(person1.firstName === "Fernando" && person1.lastName === "Alonso")
    assert(person2.firstName === "Bruce" && person2.lastName === "Banner")

    /* I have declared the arg as a plain param to hide its visibility from the outside. I dont
    * want another classes to know about its value, and just get the values for name and lastname.*/
  }

  test("8. Make a class Car with read-only properties for manufacturer, model name, and model " +
    "year, and a read-write property for the license plate. Supply four constructors. All " +
    "require the manufacturer and model name. Optionally, model year and license plate can also " +
    "be specified in the constructor. If not, the model year is set to -1 and the license plate " +
    "to the empty string. Which constructor are you choosing as the primary constructor? Why?") {

    val car1 = new Car("Renault", "Megane")
    val car2 = new Car("Renault", "Megane", 2014)
    val car3 = new Car("Renault", "Megane", "1234 TYZ")
    val car4 = new Car("Renault", "Megane", 2014, "1234 TYZ")

    assert(car1.modelYear === -1 && car1.licensePlate === "")
    assert(car2.licensePlate === "")
    assert(car3.modelYear === -1)
    car3.licensePlate = "0000 HXY"
    assert(car3.licensePlate === "0000 HXY")

    /* As i was forced to create 4 constructors (primary one plus 3 auxiliary ones), i chose the
    one with 4 arguments as the primary constructor. By doing that, i can rewrite this() calls to
    previous auxiliary constructor for each case. */
  }

  test("9. Reimplement the class of the preceding exercise in Java, C# or C++ (your choice). " +
    "How much shorter is the Scala class?") {

    /* To check the diff between the Scala and the Java Car classes, check them out at the
     chapter5/classes package. It would have been a really bigger difference if i would have
     used default params, but i was forced not to do it because the exercise asked me to
     use 4 constructors. Using default params, 1 constructor (the primary one) would have been
     enough. */
  }

  test("10. Consider the class" +
    "" +
    "class Employee(val: name: String, var salary: Double) {" +
    "   def this() { this(\"John Q. Public\", 0.0) }" +
    "}" +
    "" +
    "Rewrite i to use explicit fields and a default primary constructor. Which form do you " +
    "prefer? Why?") {

    val employee = new Employee()
    val employee2 = new Employee("John Doe")
    val employee3 = new Employee("John Doe", 5000.0)
    val employee4 = new Employee(paramSalary = 5000)

    assert(employee.name === "John Q. Public" && employee.salary === 0.0)
    assert(employee2.name === "John Doe" && employee2.salary === 0.0)
    assert(employee3.name === "John Doe" && employee3.salary === 5000.0)
    assert(employee4.name === "John Q. Public" && employee4.salary === 5000)

    /* I would totally choose the default primary constructor mode, as it is really simple but
    so powerful. */
  }
}
