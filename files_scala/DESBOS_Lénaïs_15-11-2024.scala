// Databricks notebook source
def multiply(a: Int, b: Int): Int = a * b

// COMMAND ----------

val result_after_first_call = multiply(3,4)

// COMMAND ----------

val result_after_second_call = multiply(3,4)

// COMMAND ----------

var total = 0

def addToTotal(a: Int): Int = {
  total += a
  total
}

// COMMAND ----------

var total_after_first_call = addToTotal(5)

// COMMAND ----------

var total_after_second_call = addToTotal(5)

// COMMAND ----------

val list = List(4,5,6)

// COMMAND ----------

list = List(3,4,5,6)
list1 = List(3,4,5,6)

// COMMAND ----------

val newList = 3 :: list

// COMMAND ----------

list = List(3,4,5,6)

// COMMAND ----------

val greet = (name: String) => s"Hello, $name!"

// COMMAND ----------

println(greet("Lénaïs"))

// COMMAND ----------

def applyTwice(f: Int => Int, x: Int): Int = f(f(x))

// COMMAND ----------

val increment = (x: Int) => x +1

// COMMAND ----------

println(applyTwice(increment, 5))

// COMMAND ----------

def multiplier(factor: Int): Int => Int = {
  (x: Int) => x * factor
}

// COMMAND ----------

val triple = multiplier(3)
println(triple(20))

// COMMAND ----------

//(val1: Type1, val2: Type2) => expression

(x: Int, y: Int) => x + y

// COMMAND ----------

def add(x: Int)(y: Int): Int = x + y

// COMMAND ----------

println(add(5)(10))

// COMMAND ----------

val addFive = add(5)_

// COMMAND ----------

println(addFive(10))

// COMMAND ----------

def log(level: String)(message: String): Unit = {
  println(s"[$level] $message")
}

// COMMAND ----------

val infoLog = log("INFO")_
val errorLog = log("ERROR")_

// COMMAND ----------

val numbers = List(1,2,3,4,5)

val doubled = numbers.map(_ * 2)
println(doubled)

// COMMAND ----------

val nestedNumbers = List(List(1,2), List(3,4), List(5,6,7))


val incremented = nestedNumbers.flatMap(list => list.map(_ + 1))
println(incremented)

// COMMAND ----------

val doubledEvens = numbers.collect { case x if x % 2 == 0 => x * 2 }
println(doubledEvens)

// COMMAND ----------

val evens = numbers.filter(_ % 2 == 0)
println(evens)

// COMMAND ----------

val odds = numbers.filter(_ % 2 == 1)
println(odds)

// COMMAND ----------

val lessThanFour = numbers.takeWhile(_ < 4)
println(lessThanFour)

// COMMAND ----------

val fromFourOnwards = numbers.takeWhile(_ > 4)
println(fromFourOnwards)

// COMMAND ----------

val sum = numbers.reduce(_ + _)
println(sum)

// COMMAND ----------

val words = List("Scala", "is", "not", "fun")
val sentence = words.foldLeft("Programming in")(_ + " " + _)
println(sentence)

// COMMAND ----------

val words = List("Scala", "is", "not", "fun")
val sentenceRight = words.foldRight("!")(_ + " " + _)
println(sentence)

// COMMAND ----------

val maxNumber = numbers.reduceLeft((x,y) => if (x > y) x else y)
println(maxNumber)

// COMMAND ----------

val minNumber = numbers.reduceRight((x,y) => if (x < y) x else y)
println(minNumber)

// COMMAND ----------

val sumOfSquares = numbers.aggregate(0)(
  (acc, num) => acc + num * num,
  (acc1, acc2) => acc1 + acc2
)
println(sumOfSquares)

// COMMAND ----------

val setA = Set(1,2,3)
val setB = Set(4,5,6)

// COMMAND ----------

println(setA union setB)

// COMMAND ----------

println(setA intersect setB)

// COMMAND ----------

lazy val expensiveComputation = {
  println("Performing expensive computation...")
  Thread.sleep(100)
  42
}
