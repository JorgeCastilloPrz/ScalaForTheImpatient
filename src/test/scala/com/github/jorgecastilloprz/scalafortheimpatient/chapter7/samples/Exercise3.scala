package com.github.jorgecastilloprz.scalafortheimpatient.chapter7

/**
 * 3. Write a package random with functions nextInt(): Int, nextDouble(): Double, and
 * setSeed(seed: Int): Unit. To generate random numbers, use the linear congruential generator:
 * next = (previous * a + b) mod 2^n where a = 1664525, b = 1013904223, n = 32, and the initial
 * value of previous is seed.
 *
 * In Scala, you CANNOT add functions or variables to a package. You can just add classes, objects,
 * and traits. The only way available to achieve the same behavior, is to use Package Objects.
 *
 * Package Objects are defined at the immediate parent package. If your package is random, you
 * could define a package object random too in its parent package. Every package can have just
 * one package object. It must have the same name than the child package which is representing to.
 */
package object random {
  var seed: Int = 0

  def nextInt() = {
    seed = seed * 1664525 + 1013904223 % (2 ^ 32)
    seed
  }

  def nextDouble(): Double = nextInt().toDouble / Int.MaxValue.toDouble

  def setSeed(value: Int) = seed = value
}

import random._

object Exercise3App extends App {
  seed = 123456 //can do it as it is totally imported and its a var
  setSeed(123456) // you can do this too
  println(seed)
  (1 to 5).foreach(x => println(nextInt()))
  (1 to 5).foreach(x => println(nextDouble()))
}