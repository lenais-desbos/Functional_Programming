// Databricks notebook source
// MAGIC %md
// MAGIC #Problem
// MAGIC
// MAGIC There is a problem with my data. I cant put the right name at the top of columns but it works correctly on last time document (DESBOS_Lénaïs_05_11_2024_Afternoon). It was the exact same code that you are asking us to write again today.

// COMMAND ----------

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.types.{IntegerType, StringType, StructType}

// COMMAND ----------

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
      .option("inferSchema", "true")
      .csv(csvDataFile)
      .drop("acceptedAnswer")

// COMMAND ----------

val schema = new StructType()
  .add("postTypeId", IntegerType, nullable = true)
  .add("id", IntegerType, nullable = true)
  .add("acceptedAnswer", StringType, nullable = true)
  .add("parentId", IntegerType, nullable = true)
  .add("score", IntegerType, nullable = true)
  .add("tag", StringType, nullable = true)

// COMMAND ----------

val df = spark.read
      .option("header", "false")
      .option("inferSchema", "true")
      .csv(csvDataFile)
      .drop("acceptedAnswer")

// COMMAND ----------

println(s"\nCount of records in CSV file: ${df.count()}")

// COMMAND ----------

df.printSchema()

// COMMAND ----------

df.show(5)

// COMMAND ----------

//score <=> c4
val highScorePosts = df.filter(col("_c4") > 20)
highScorePosts.show(5)

// COMMAND ----------

df.createOrReplaceTempView("stackoverflow")

// COMMAND ----------

// Query 1: Top 5 highest scores
val top5Scores = spark.sql("""
  SELECT id,tag ,score
  FROM stackoverflow
  ORDER BY score DESC
  LIMIT 5
""")
top5Scores.show()

// COMMAND ----------

// Query 2: Top 5 highest scores with non-null tags
val top5ScoresWithTag = spark.sql("""
  SELECT id, score, tag
  FROM stackoverflow
  WHERE tag IS NOT NULL
  ORDER BY score DESC
  LIMIT 5
""")
top5ScoresWithTag.show()

// COMMAND ----------

// Query 3: Most frequently used tags
val popularTags = spark.sql("""
  SELECT tag, COUNT(*) as frequency
  FROM stackoverflow
  WHERE tag IS NOT NULL
  GROUP BY tag
  ORDER BY frequency DESC
  LIMIT 10
""")
popularTags.show()
