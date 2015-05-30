package com {

  class ComElement {
    /* Created for visibility */
  }

  package horstmann {

    class HorstMannElement {
      /* Created for visibility */
    }

    package impatient {
      class ImpatientBook {
        //You can use them without imports, as they are in scope!
        val comElem : ComElement = new ComElement
        var horstElem = new HorstMannElement
      }
    }
  }
}

package com.horstmann.impatient {

import com.ComElement
import com.horstmann.HorstMannElement

class Book {
    //You cannot use them without imports, as they are NOT in scope.
    var comElem = new ComElement
    var horstElem = new HorstMannElement
  }
}

/* As you can see, the com.horstman.impatient {} syntax does not allow you to use elements
* declared into the com, or com.horstmann packages. You must import them manually for it. Its a
* matter of hidden visibility that Scala applies when you declare packages by that way.
*
* If you declare a package like
 *
* package com
* package horstmann
* package impatient
*
* ... (code) ...
*
* You will be have visibility of every object or class declared into all the packages on the
* hierarchy starting from the root package, to the immediate parent package. */