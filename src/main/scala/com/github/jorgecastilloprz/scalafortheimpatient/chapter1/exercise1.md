Exercise 1:
-----------
*In the Scala REPL, type 3. followed by the Tab key. ¿What methods can be applied?*

```
scala> 3.
!=   %   *   -   <    <=       ==   >=   >>>   asInstanceOf   getClass   isInstanceOf   toChar     toFloat   toLong    toString   unary_-   |
##   &   +   /   <<   <init>   >    >>   ^     equals         hashCode   toByte         toDouble   toInt     toShort   unary_+    unary_~
```
That is the result printed when pressing Tab after typing "3.". Everything you can find in the print is a method.
In scala, methods can have any name, so operators like "!=", "*", "<=" are methods too. You could add an int to another by doing:

```
scala> 3.+(2)
res1: Int = 5
```

In `Scala`, primitive types are objects too, so they have plenty of methods that you cannot find if you work with the
same type in `Java`.