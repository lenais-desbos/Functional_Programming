// Databricks notebook source
// MAGIC %md
// MAGIC ##Goal
// MAGIC
// MAGIC - Filter users aged 25 and above.
// MAGIC - Transform data to extract names and cities.
// MAGIC - Group users by city.

// COMMAND ----------

// MAGIC %md
// MAGIC ###Data
// MAGIC
// MAGIC - id,name,age,city
// MAGIC - 1,P1,28,New York
// MAGIC - 2,P2,22,San Francisco
// MAGIC - 3,P3,30,New York
// MAGIC - 4,P4,25,Boston
// MAGIC - 5,P5,35,San Francisco

// COMMAND ----------

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

// COMMAND ----------

val csvDataFile = "/FileStore/tables/data-2.csv"

// COMMAND ----------

val df = spark.read.option("header", "false").option("inferSchema", "true").csv(csvDataFile)

// COMMAND ----------

//df.printSchema()
df.show(6)

// COMMAND ----------

//Filter users aged 25 and above.

