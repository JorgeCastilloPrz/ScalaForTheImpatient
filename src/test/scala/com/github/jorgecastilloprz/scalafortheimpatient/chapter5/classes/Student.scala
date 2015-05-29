package com.github.jorgecastilloprz.scalafortheimpatient.chapter5.classes

import scala.beans.BeanProperty

/**
 * @author jorge
 * @since 29/05/15
 */
class Student(@BeanProperty val name: String, @BeanProperty val id: Long) {

}
