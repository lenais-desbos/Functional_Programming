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


// COMMAND ----------

Logger.getLogger("org").setLevel(Level.ERROR)

val programStartTime = System.nanoTime()

val csvDataFile = "/FileStore/tables/stackoverflow.csv"

spark.sparkContext.setLogLevel("ERROR")

val df = spark.read.option("header", "false").option("inferSchema", "true").csv(csvDataFile)

println(s"\nCount of records in csv file: ${df.count()}")
df.printSchema()
df.show(5)

val programElapsedTime = (System.nanoTime() - programStartTime) / 1e9

// COMMAND ----------

println(s"\nProgram execution time: $programElapsedTime seconds")
println(s"\n.......Program *****Completed***** Successfully.....!\n")

// COMMAND ----------

import org.apache.spark.sql.functions.col
import org.apache.spark.sql.types.{IntegerType, StringType, StructType}

// COMMAND ----------

Logger.getLogger("org").setLevel(Level.ERROR)

val programStartTime = System.nanoTime()

val csvDataFile = "/FileStore/tables/stackoverflow.csv"

val schema = new StructType()
  .add("postTypeId", IntegerType, nullable = true)
  .add("id", IntegerType, nullable = true)
  .add("acceptedAnswer", StringType, nullable = true)
  .add("parentId", IntegerType, nullable = true)
  .add("score", IntegerType, nullable = true)
  .add("tag", StringType, nullable = true)

val df = spark.read
  .option("header", "false")
  .schema(schema)
  .csv(csvDataFile)
  .drop("acceptedAnswer")

println(s"\nCount of records in CSV file: ${df.count()}")
df.printSchema()
df.show(5)

val programElapsedTime = (System.nanoTime() - programStartTime) / 1e9

// COMMAND ----------

println(s"\nProgram execution time: $programElapsedTime seconds")
println(s"\n.......Program *****Completed***** Successfully.....!\n")

// COMMAND ----------

import spark.implicits._

// COMMAND ----------

println(
  "\nCount tag null: " + df.filter($"tag".isNull).count() +
  "\nCount parentId null: " + df.filter($"parentId".isNull).count()
)

// COMMAND ----------

val highScorePosts = df.filter(col("score") > 20)
highScorePosts.show(20)

// COMMAND ----------

val popularTags = spark.sql("""
  SELECT tag, COUNT(*) as frequency
  FROM stackoverflow
  WHERE tag IS NOT NULL
  GROUP BY tag
  ORDER BY frequency DESC
  LIMIT 10
""")
popularTags.show(5)
