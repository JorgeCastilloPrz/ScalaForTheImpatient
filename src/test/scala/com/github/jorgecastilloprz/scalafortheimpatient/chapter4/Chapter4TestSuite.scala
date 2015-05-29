package com.github.jorgecastilloprz.scalafortheimpatient.chapter4

import java.io.File
import java.util.{Calendar, Scanner}

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.collection.{SortedMap, mutable}

/**
 * @author jorge
 * @since 26/05/15
 */
@RunWith(classOf[JUnitRunner])
class Chapter4TestSuite extends FunSuite {

  test("1. Set up a map of prices for a number of products. Then produce a second map with the " +
    "same keys and the prices at a 10 percent discount.") {

    val mapOfPrices: Map[String, Double] = Map("Watch" -> 50.99, "Table" -> 24.50, "Apple Watch" -> 999999999,
      "Umbrella" -> 5.75, "Water" -> 0.99)

    assert(mapOfPrices.size === 5 && mapOfPrices("Apple Watch") === 999999999)

    val mapOfPricesTenPercentCheaper = for ((k, v) <- mapOfPrices) yield (k, v * 0.1)
    assert(mapOfPricesTenPercentCheaper("Watch") === 5.099)
    assert(mapOfPricesTenPercentCheaper("Table") === 2.45)
    assert(mapOfPricesTenPercentCheaper("Apple Watch") === 99999999.9)
    assert(mapOfPricesTenPercentCheaper("Umbrella") === 0.5750000000000001)
    assert(mapOfPricesTenPercentCheaper("Water") === 0.099)
  }

  test("2. Write a program that reads words from a file. Use a mutable map to count how often " +
    "each word appears. To read the words, simply use a java.util.Scanner:" +
    "" +
    "val in = new java.util.Scanner(new java.io.File('myfile.txt'))" +
    "while (in.hasNext()) process in.next()" +
    "" +
    "At the end, print out all words and their counts") {

    printWordsFromWordMapMutable(getWordCountMapFromFileMutable("MockFile.txt"))
  }

  def printWordsFromWordMapMutable(wordMap: scala.collection.mutable.Map[String, Int]): Unit = {
    println("Mutable map word count:")
    for ((k, v) <- wordMap) print(k + ": " + v + " ")
  }

  def getWordCountMapFromFileMutable(fileName: String): scala.collection.mutable.Map[String, Int] = {
    val mutableMap = scala.collection.mutable.Map[String, Int]()
    val in = new Scanner(new File(fileName))
    while (in.hasNext) {
      val nextWord = in.next
      mutableMap += (nextWord -> (mutableMap.getOrElse(nextWord, 0) + 1))
    }
    mutableMap
  }

  test("3. Repeat exercise 2 with an immutable map") {
    printWordsFromWordMap(getWordCountMapFromFile("MockFile.txt"))
  }

  def printWordsFromWordMap(wordMap: Map[String, Int]): Unit = {
    println("\nImmutable map word count:")
    for ((k, v) <- wordMap) print(k + ": " + v + " ")
  }

  /**
   * The map is not mutable, but you can reassign the map variable if you declare it as a mutable
   * var. That is a tricky way to update the values of an immutable map (you dont really update the
   * values from it, but create a copy with the new items).
   */
  def getWordCountMapFromFile(fileName: String): Map[String, Int] = {
    var map = Map[String, Int]()
    val in = new Scanner(new File(fileName))
    while (in.hasNext) {
      val nextWord = in.next
      map += (nextWord -> (map.getOrElse(nextWord, 0) + 1))
    }
    map
  }

  test("4. Repeat the preceding exercise with a sorted map, so that the words are prined in " +
    "sorted order.") {
    printWordsFromWordMapSorted(getWordCountMapFromFileSorted("MockFile.txt"))
  }

  def printWordsFromWordMapSorted(wordMap: SortedMap[String, Int]): Unit = {
    println("\nSorted map word count:")
    for ((k, v) <- wordMap) print(k + ": " + v + " ")
  }

  /**
   * You just need to use SortedMap to get the map sorted by its keySet.
   */
  def getWordCountMapFromFileSorted(fileName: String): SortedMap[String, Int] = {
    var map = SortedMap[String, Int]()
    val in = new Scanner(new File(fileName))
    while (in.hasNext) {
      val nextWord = in.next
      map += (nextWord -> (map.getOrElse(nextWord, 0) + 1))
    }
    map
  }

  test("5. Repeat the preceding exercise with java.util.TreeMap that you adapt to the Scala API.") {
    printWordsFromWordTreeMap(getWordCountTreeMapFromFile("MockFile.txt"))
  }

  def printWordsFromWordTreeMap(wordMap: scala.collection.mutable.Map[String, Int]): Unit = {
    println("\nTreeMap adapted to Scala API word count:")
    for ((k, v) <- wordMap) print(k + ": " + v + " ")
  }

  /**
   * TreeMap is sorted by keys too
   */
  def getWordCountTreeMapFromFile(fileName: String): scala.collection.mutable.Map[String, Int] = {
    val map: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]()
    val in = new Scanner(new File(fileName))
    while (in.hasNext) {
      val nextWord = in.next
      map += (nextWord -> (map.getOrElse(nextWord, 0) + 1))
    }
    map
  }

  test("6. Define a linked hash map that maps \"Monday\" to java.util.Calendar.MONDAY, and " +
    "similarly for the other weekdays. Demonstrate that the elements are visited in insertion " +
    "oder.") {

    assert(getWeekDaysLinkedHashMap.size === 7)
    assert(getWeekDaysLinkedHashMap("Wednesday") === Calendar.WEDNESDAY)
    assert((for (key <- getWeekDaysLinkedHashMap.keySet) yield key) ===
      Set("Wednesday", "Monday", "Saturday", "Thursday", "Tuesday", "Friday", "Sunday"))
  }

  def getWeekDaysLinkedHashMap: mutable.LinkedHashMap[String, Int] = {
    val weekDays: mutable.LinkedHashMap[String, Int] = mutable.LinkedHashMap(
      "Monday" -> Calendar.MONDAY, "Tuesday" -> Calendar.TUESDAY, "Wednesday" -> Calendar.WEDNESDAY,
      "Thursday" -> Calendar.THURSDAY, "Friday" -> Calendar.FRIDAY, "Saturday" -> Calendar.SATURDAY,
      "Sunday" -> Calendar.SUNDAY)

    weekDays
  }

  test("7. Print a table of all Java roperties, like this:" +
    "java.runtime.name      | Java(TM) SE Runtime Enviroment" +
    "sun.boot.library.path  | /home/apps/jdk1.6.0_21/jre/lib/i386" +
    "java.vm.version        | 17.0-b16" +
    "java.vm.vendor         | Sun Microsystems Inc." +
    "java.vendor.url        | http://java.sun.com/" +
    "path.separator         | :" +
    "java.vm.name           | Java HotSpot(TM) Server VM" +
    "" +
    "You need to find the length of the longest key before you can print the table") {

    printJavaPropertiesFormattedTable
  }

  def printJavaPropertiesFormattedTable {
    val props: scala.collection.Map[String, String] = System.getProperties
    val longestPropLength = props.keySet.maxBy(_.length).length
    println("\n\nFormatted Java system properties table:\n")
    for ((k, v) <- props) println(k + " " * (longestPropLength - k.length + 1) + "| " + v)
  }

  test("8. Write a function minmax(values: Array[Int]) that returns a pair containing the " +
    "smallest and largest values in the array") {

    assert(minmax(Array(3, 99, -12, 0, 9, 679, 51)) ===(-12, 679))
  }

  def minmax(values: Array[Int]) = (values.min, values.max)

  test("9. Write a function lteqgt(values: Array[Int], v: Int) that returns a triple containing " +
    "the counts of values less than v, equal to v, and greater than v") {

    assert(lteqgt(Array(3, 99, -12, 0, 9, 679, 51), 20) ===(4, 0, 3))
  }

  def lteqgt(values: Array[Int], v: Int) =
    (values.count(_ < v), values.count(_ == v), values.count(_ > v))

  test("10. What happens when you zip together two strings, such as \"Hello\".zip(\"World\")? " +
    "Come up with a plausible use case.") {

    assert("Hello".zip("World") ===
      Vector(('H', 'W'), ('e', 'o'), ('l', 'r'), ('l', 'l'), ('o', 'd')))
    //generates a Vector of pairs (tuples of 2 elements)

    println("Decrypt Lorem ipsum text: " + decryptText("Lorem ipsum dolor sit amet,").mkString(" "))

  }

  def decryptText(text: String) = {
    val encryptionPairs = getEncryptionEquivalencePairs()
    for ((k, v) <- encryptionPairs) yield k
  }

  def getEncryptionEquivalencePairs() = {
    val seedText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
      "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis " +
      "nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute" +
      " irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla " +
      "pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia " +
      "deserunt mollit anim id est laborum."

    "Hello World, this is a test!".zip(seedText)
  }
}
