// Databricks notebook source
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

// COMMAND ----------

Logger.getLogger("org").setLevel(Level.ERROR)

val programStartTime = System.nanoTime()

val logFile = "/FileStore/tables/README.md"
val logData = spark.read.textFile(logFile).cache()

val numAs = logData.filter(line => line.contains("a")).count()
val numBs = logData.filter(line => line.contains("b")).count()

println(s"Lines with a: $numAs, Lines with b: $numBs")

val programElapsedTime = (System.nanoTime() - programStartTime) / 1e9
println(s"\nProgram execution time: $programElapsedTime seconds")
println(s"\n.......Program *****Completed***** Successfully.....!\n")

