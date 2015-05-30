/*
If you declare package com again into the package hierarchy, the resolutions using the absolute
path like com.horstmann.SomeElement will fail, as Scala starts resolution in the immediate
parent package.
 */
package com {
  package horstmann {

    class SomeElement {
      /* Created for visibility */
    }

    package com {

      class BafflerPuzzler {
        //By this syntax, it works properly as it is in scope
        val horstmanElem = new SomeElement

        //But this one will not work anymore. You could end up breaking a lot of code of your mates.
        //I commented it to allow the IDE to compile.
        //val asd = new com.horstmann.SomeElement
      }
    }
  }
}