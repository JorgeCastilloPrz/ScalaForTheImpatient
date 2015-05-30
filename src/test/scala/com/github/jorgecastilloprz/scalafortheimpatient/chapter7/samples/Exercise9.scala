package com.github.jorgecastilloprz.scalafortheimpatient.chapter7.samples

import java.lang.System._

/**
 * 9. Write a program that imports the java.lang.System class, reads the user name from the
 * user.name system property, reads a password from the Console object, and prints a message to
 * the standard error stream if the password is not \"secret\". Otherwise, print a greeting to the
 * standard output stream. Do not use any other imports, and do not use any qualified names
 * (with dots).
 *
 * @author jorge
 * @since 30/05/15
 */
object Exercise9 extends App {

  val user = getProperty("user.name")
  val password = Console.readLine("password:")

  if (password != "secret")
    err.println("Invalid password!")
  else
    println("Welcome %s!".format(user))
}