// Databricks notebook source
(x: Int) => x + 1

// COMMAND ----------

val addOne = (x: Int) => x+1
println(addOne(1))

// COMMAND ----------

val add = (x: Int, y: Int) => x + y
println(add(2,4))

// COMMAND ----------

val getTheAnswer = () => 42
println(getTheAnswer())

// COMMAND ----------

def add(x: Int, y: Int): Int = x + y
println(add(1,5))

// COMMAND ----------

def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
println(addThenMultiply(4,5)(6))

// COMMAND ----------

class Greeter(prefix: String, suffix: String) {
  def greet(name: String): Unit =
    println(prefix + name + suffix)
}

// COMMAND ----------

val greeter = new Greeter("Hello ", "!")
greeter.greet("Scala developer")

// COMMAND ----------

case class Point(x: Int, y: Int)

// COMMAND ----------

val point = Point(2,3)
val anotherPoint = Point(2,3)
val yetAnotherPoint = Point(7,3)

// COMMAND ----------

if (point == anotherPoint) {
  println(s"$point and $yetAnotherPoint are the same")
}

// COMMAND ----------

object IdFactory {
  private var counter = 0
  def create(): Int = {
    counter += 1
    counter
  }
}

// COMMAND ----------

val newId: Int = IdFactory.create()
val newId2: Int = IdFactory.create()
val newId3: Int = IdFactory.create()

// COMMAND ----------

trait Greeter {
  def greet(name: String): Unit =
    println("Hello "+ name + "!")
}

// COMMAND ----------

//class DefaultGreeter extends Greeter

class CustomiezableGreeter(prefix: String, postfix: String) extends Greeter {
  override def greet(name: String): Unit = {
    println(prefix + name + postfix)
  }
}

val newGreeter = new CustomiezableGreeter("Bonjour ", ".")
newGreeter.greet("M. Iori")

// COMMAND ----------

object Main {
  def main(args: Array[String]): Unit =
    println("Hello, new Scala developper!")
}
