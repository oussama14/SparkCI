package com.ci
import org.apache.spark.sql.Row.empty.schema
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.types.{ArrayType, IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{SaveMode, SparkSession}

object SparkCSV {
  def main(args: Array[String]): Unit = {
    val appName = args(0)
    val path = args(1)
    val spark = SparkSession
      .builder()
      .master("local[*]")
      .appName(appName)
      .getOrCreate()
    import spark.implicits._
    val df = spark.read.format("csv")
      .option("delimiter",";")
      .option("header","true")
      .option("inferSchema","true")
      .load(path)
    df.printSchema()
    val header = df.first()
    val df1 = df.filter(row=>row != header)
    df1.show()

  }

}
