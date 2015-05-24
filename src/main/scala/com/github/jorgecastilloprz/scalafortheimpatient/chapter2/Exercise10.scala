package com.github.jorgecastilloprz.scalafortheimpatient.chapter2

/**
 * Write a function that computes x pow n where n is a integer. Use the following recursive definition:
 * X pow n = y pow 2 , if n is even and positive, where y = x pow n/2
 * x pow n = x * x pow n-1 , if n is odd and positive
 * x pow 0 = 1
 * x pow n = 1 / (x pow -n) , if n is negative
 *
 * Don't use return statement
 *
 * @author jorge
 * @since 24/05/15
 */
object Exercise10 {

  def main(args: Array[String]) {
    println(pow(2, 3))
  }

  def pow(x: Int, n: Int): Long = {
    val res = if (n == 0) 1
    else
    if (n < 0) 1 / (x * pow(x, n - 1))
    else if (n % 2 != 0) x * pow(x, n - 1)
    else pow(x, n / 2) * pow(x, n / 2)

    res
  }
}
