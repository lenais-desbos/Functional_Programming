// Databricks notebook source
def f(x:Int): Int = x*3
def g(x:Int): Int = x+1
def h(x:Int): Int = f(g(x))

// COMMAND ----------

val input = 2
println(s"g($input) = ${g(input)}")
println(s"f(g($input)) = ${f(g(input))}")
println(s"h($input) = ${h(input)}")

// COMMAND ----------

val name: String = "Mateo"
val age: Int = 23

// COMMAND ----------

val someone: Int = "Mateo"

// COMMAND ----------

//Not in Python here so it doesn't work
x = "Python"
print(x)

x = 45
print(x)

// COMMAND ----------

def add(x: Int, y: Int): Int = x + y
val sum = add(15, 30)
println(s"Sum is: $sum")

// COMMAND ----------

val sum2 = add(10, "20")

// COMMAND ----------

val x = 15
val y = 30
val z = x + y

// COMMAND ----------

val z = x.+ (y)
val z1 = x.*(y)

// COMMAND ----------

trait Shape {
  def area(): Int
}

class Square(lenght: Int) extends Shape {
  def area = lenght * lenght
}

class Rectangle(lenght: Int, width: Int) extends Shape {
  def area = lenght * width
}

val square = new Square(5)
val area = square.area

val rectangle = new Rectangle(8, 3)
val area2 = rectangle.area

// COMMAND ----------

val twoElements = ("10", true)
val threeElements = (20, "Mateo", false)

// COMMAND ----------

val first = threeElements._1
val second = threeElements._2
val third = threeElements._3

// COMMAND ----------

val arr = Array(11, 21, 31, 41)

// COMMAND ----------

arr(0) = 51

// COMMAND ----------

val first = arr(0)

// COMMAND ----------

val xs = List(1, 2, 3, 4)

// COMMAND ----------

val ys = (1 to 50).toList

// COMMAND ----------

val zs = arr.toList

// COMMAND ----------

zs.head

// COMMAND ----------

zs.tail

// COMMAND ----------

zs.isEmpty

// COMMAND ----------

val v1 = Vector(0, 1, 2, 3, 4)

// COMMAND ----------

val v2 = v1 :+ 5

// COMMAND ----------

val v3 = v2 :+ 6

// COMMAND ----------

val v4 = v3(4)

// COMMAND ----------

val v5 = v3(6)

// COMMAND ----------

val fruits = Set("apple", "orange", "pear", "banana")

// COMMAND ----------

val fruits = Set("apple", "orange", "pear", "banana", "apple")

// COMMAND ----------

fruits.contains("ananas")

// COMMAND ----------

fruits.contains("orange")

// COMMAND ----------

fruits.contains("Orange")

// COMMAND ----------

fruits.isEmpty

// COMMAND ----------

val capitals = Map("France" -> "Paris", "USA" -> "Washington D.C.", "UK" -> "London")

// COMMAND ----------

val UKCapital = capitals("UK")

// COMMAND ----------

val myList = List(1.0, 2.0, 3.0, 4.0)

// COMMAND ----------

val myOtherList = myList.map((x: Double) => x * 2)

// COMMAND ----------

val myAnotherList = myList.map(_ * 3)

// COMMAND ----------

val myList2 = List(1, 2, 3, 4)

// COMMAND ----------

val myOtherList2 = myList2.map((x: Int) => x * 10.0)

// COMMAND ----------

val interType = myList.map {x => x * 10.0}

// COMMAND ----------

val functionLiteral = myList.map {_*10.0}

// COMMAND ----------

val line = "Scala is fun"

// COMMAND ----------

val SingleSpace = " "

// COMMAND ----------

val words = line.split(SingleSpace)

// COMMAND ----------

val arrayOfListOfChars = words.map{x => x.toList}

// COMMAND ----------

val arrayOfListOfChars = words.map{_.toList}

// COMMAND ----------

val arrayOfChars = words.flatMap{x => x.toList}

// COMMAND ----------

val myNewList = (0 to 100).toList

// COMMAND ----------

val even = myNewList.filter {_ %2 == 0}

// COMMAND ----------

val even = myNewList.filter(_ %2 == 0)

// COMMAND ----------

val words = "Scala is fun".split(" ")

// COMMAND ----------

words.foreach(println)

// COMMAND ----------

val reduceList = List(2, 4, 6, 8, 10)

// COMMAND ----------

val sum = reduceList.reduce{(x, y) => x + y}

// COMMAND ----------

val multiplication = reduceList.reduce{(x, y) => x * y}

// COMMAND ----------

val min = reduceList.reduce{(x, y) => if (x < y) x else y}

// COMMAND ----------

val max = reduceList.reduce{(x, y) => if (x > y) x else y}
