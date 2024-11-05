// Databricks notebook source
var x = 10

// COMMAND ----------

x = 20

// COMMAND ----------

val y = 10

// COMMAND ----------

y = 20

// COMMAND ----------

def add(a: Int, b: Int): Int = {
  val sum = a+b
  return sum
}

// COMMAND ----------

val addNumbers = add(5, 6)

// COMMAND ----------

def addSimple(firstInput: Int, secondInput: Int) = firstInput + secondInput

// COMMAND ----------

val simpleAdd = addSimple(5, 6)

// COMMAND ----------

def encode(n: Int, f: (Int) => Long): Long = {
  val x = n * 10
  f(x)
}

// COMMAND ----------

(x: Int) => {
  x + 100
}

// COMMAND ----------

val higherOrderFunctionTest1 = encode(5, (x: Int) => (x+100))

// COMMAND ----------

val higherOrderFunctionTest2 = encode(20, (x: Int) => (x+100))

// COMMAND ----------

val higherOrderFunctionTest3 = encode(5, x => x+100)

// COMMAND ----------

val higherOrderFunctionTest4 = encode(5, _+100)

// COMMAND ----------

class Car(mk: String, ml: String, cl: String) {
  val make = mk
  val model = ml
  var color = cl
  def repaint(newColor: String) = {
    color = newColor
  }
}

// COMMAND ----------

val mustang = new Car("Ford", "Mustang", "Red")
val corvette = new Car("GM", "Corvette", "Black")

// COMMAND ----------

mustang.color

// COMMAND ----------

mustang.repaint("Green")

// COMMAND ----------

mustang.color

// COMMAND ----------

case class Message(from : String, to: String, content: String)

// COMMAND ----------

val request = Message("Lénaïs", "Mateo", "<3")

// COMMAND ----------

def colorToNumber(color: String): Int = {
  val num = color match {
    case "Red" => 1
    case "Blue" => 2
    case "Green" => 3
    case "Yellow" => 4
    case _ => 0
  }
  num
}

// COMMAND ----------

val colorName = "Red"
val colorCode = colorToNumber(colorName)
print("The color for ", colorCode, " is ", colorName)

// COMMAND ----------

def f(x: Int, y: Int, operator: String): Double = {
  operator match {
    case "+" => x+y
    case "-" => x-y
    case "*" => x*y
    case "/" => x/y.toDouble
  }
}

// COMMAND ----------

val sum = f(10, 20, "+")
val product = f(10, 20, "*")
