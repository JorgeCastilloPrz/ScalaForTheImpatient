package com.github.jorgecastilloprz.scalafortheimpatient.chapter7

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * @author jorge
 * @since 29/05/15
 */
@RunWith(classOf[JUnitRunner])
class Chapter7TestSuite extends FunSuite {

  test("1. Write an example program to demonstrate that" +
    "package com.horstmann.impatient" +
    "" +
    "is not the same as" +
    "" +
    "package com" +
    "package horstmann" +
    "package impatient") {

    /* For this solution just check the Exercise1.scala file included into the samples package.
    * As a summary: The syntax com.horstmann.impatient hides all the classes and objects
    * declared into the packages com and com.horstmann to the com.horstmann.impatient one. It
    * is a matter of visibility. If you declare all three packages separately, you will be
    * able of using objects and classes created in com and com.horstmann packages, without
    * importing them. */
  }

  test("2. Write a puzzler that baffles your Scala friends, using a package com that is not at " +
    "the top level.") {

    /* The file Exercise2.scala included in the samples package contains a good example of this
     * matter. If you declare a package twice into the hierarchy, Scala will not be able to
     * resolve the absolute package paths that contain the earlier version of that package anymore,
     * as it will start matching by the immediate parent and will go upper and upper until it finds
     * a match for it. You have to care about package names in your project, as you could end up
     * damaging the code of the other developers too bad. */
  }

  test("3. Write a package random with functions nextInt(): Int, nextDouble(): Double, and " +
    "setSeed(seed: Int): Unit. To generate random numbers, use the linear congruential " +
    "generator:" +
    "   next = (previous * a + b) mod 2^n" +
    "where a = 1664525, b = 1013904223, n = 32, and the initial value of previous is seed.") {

    /* Checkout Exercise3.scala file into the samples package. You will find a package object
     * called random, which represents a random package which does not exist atm. In Scala, you
     * cannot define functions or variables in a package, but you can get the same behavior
     * by using package objects. This is explained properly into the Exercise3.scala file. Take
     * a look! */
  }

  test("4. Why do you think the Scala language designers provided the package object syntax " +
    "instead of simply letting you add functions and variables to a package?") {

    /* It is happening due to a limitation of the way that the JVM works. (The book says so in
     * section [7.5 Package Objects]. */
  }

  test("5. What is the meaning of private[com] def giveRaise(rate: Double) ? Is it useful?") {

    /* That means that the method giveRaise is only visible from the com package. It is useful,
     * as it is the only workaround that Scala provides to emulate the Java Package Visibility. */
  }

  import java.util.{HashMap => JavaHashMap}

  import collection.JavaConversions.mapAsScalaMap
  import collection.mutable.{Map => ScalaMap}

  test("6. Write a program that copies all elements from a Java hash map into a Scala hash map. " +
    "Use imports to rename both classes.") {

    printJavaMapConversionToScala()
  }

  def printJavaMapConversionToScala(): Unit = {
    val javaMap = new JavaHashMap[Int, String]()
    javaMap +=((0, "Zero"), (1, "One"), (2, "Two"), (3, "Three"))
    val scalaMap: ScalaMap[Int, String] = javaMap

    println(scalaMap.mkString(" "))
  }

  test("7. In the preceding exercise, move all imports into the innermost scope possible.") {
    printScalaMapWithInnermostImports()
  }

  /**
   * I just moved the imports into the function. An interesting thing in Scala is that you can
   * declare your imports in any moment, and any position of a file.
   */
  def printScalaMapWithInnermostImports(): Unit = {

    import java.util.{HashMap => JavaHashMap}

    import collection.JavaConversions.mapAsScalaMap
    import collection.mutable.{Map => ScalaMap}

    val javaMap = new JavaHashMap[Int, String]()
    javaMap +=((0, "Zero"), (1, "One"), (2, "Two"), (3, "Three"))
    val scalaMap: ScalaMap[Int, String] = javaMap

    println(scalaMap.mkString(" "))
  }

  test("8. What is the effect of:" +
    "import java._" +
    "import javax._" +
    "Is this a good idea?") {

    /*
    They are called Wildcard imports, and the "_" symbol correspond to the * java one. Those
    imports would import EVERY NAME declared into the java and javax packages. Those are huge
    packages and shouldn't ever be loaded completely. Scala has plenty of functionality to provide
    everything java does, so java imports should be a little bit rare to use. May be just if you
    need a java class because you are using some java library.
    */
  }

  test("9. Write a program that imports the java.lang.System class, reads the user name from the " +
    "user.name system property, reads a password from the Console object, and prints a message " +
    "to the standard error stream if the password is not \"secret\". Otherwise, print a greeting " +
    "to the standard output stream. Do not use any other imports, and do not use any qualified " +
    "names (with dots).") {

    /* Exercise9.scala into the samples package contains the solution. */
  }

  test("10. Apart from StringBuilder, what other members of java.lang does the scala package " +
    "override?") {

    /*
    Every Scala program implicitly starts with:
    import java.lang_
    import scala._
    import Predef._

    The scala package import is a special one. Unlike any other import, this one is allowed to
    override the preceding import. That means that every class with a name equal to another class
    contained into the java.lang package (or inner packages starting from it) will be overrided by
    the scala package version. Scala always have to rule over Java :)
     */
  }
}
