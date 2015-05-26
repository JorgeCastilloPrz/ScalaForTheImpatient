package com.github.jorgecastilloprz.scalafortheimpatient.chapter4

import java.io.File
import java.util.Scanner

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import scala.collection.SortedMap
import scala.collection.JavaConversions.mapAsScalaMap

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
}
