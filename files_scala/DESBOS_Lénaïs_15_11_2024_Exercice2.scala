// Databricks notebook source
// MAGIC %md
// MAGIC ##Exercice 2
// MAGIC
// MAGIC Create a Scala program that extract the following data from each of the source JSON file and write this extracted information into a destination JSON file. The information we are interested to identify and write into destination JSON file for each CVE is:
// MAGIC
// MAGIC - "ID" : "CVE-2024-9657",
// MAGIC - "Description: "The Element Pack Elementor Addons (Header Footer, Template Library, Dynamic Grid & Carousel, Remote Arrows) plugin for WordPress is vulnerable to Stored Cross-Site Scripting via the ‘tooltip' parameter in all versions up to, and including, 5.10.2 due to insufficient input sanitization and output escaping. This makes it possible for authenticated attackers, with Contributor-level access and above, to inject arbitrary web scripts in pages that will execute whenever a user accesses an injected page."
// MAGIC - "baseScore" : 6.5,
// MAGIC - "baseSeverity" : "MEDIUM"
// MAGIC - "exploitabilityScore" : 2.8,
// MAGIC - "impactScore" : 3.6

// COMMAND ----------

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

// COMMAND ----------

val csvDataFile = "/FileStore/tables/nvdcve-1.1-2024.json" 

// COMMAND ----------

val df = spark.read.option("header", "false").option("inferSchema", "true").csv(csvDataFile)
