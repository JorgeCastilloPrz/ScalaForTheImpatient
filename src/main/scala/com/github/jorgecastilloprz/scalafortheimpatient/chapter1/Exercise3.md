Exercise 1:
-----------
* Are the `res` variables val or var?

`res` variables printed by the REPL are `val`. That means that those variables are immutable. You can define your own
variables (mutable or immutable) in the REPL by using normal syntax:

```
scala> var myTempVar = 1+1
myTempVar: Int = 2

scala> myTempVar = 17
myTempVar: Int = 17
```

As you declared it as a mutable `var`, you can reassign a new value to it.