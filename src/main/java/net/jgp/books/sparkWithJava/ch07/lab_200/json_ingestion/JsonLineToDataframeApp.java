package net.jgp.books.sparkWithJava.ch07.lab_200.json_ingestion;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * CSV ingestion in a dataframe.
 * 
 * @author jperrin
 */
public class JsonLineToDataframeApp {

  /**
   * main() is your entry point to the application.
   * 
   * @param args
   */
  public static void main(String[] args) {
    JsonLineToDataframeApp app = new JsonLineToDataframeApp();
    app.start();
  }

  /**
   * The processing code.
   */
  private void start() {
    // Creates a session on a local master
    SparkSession spark = SparkSession.builder()
        .appName("JSON to Dataset")
        .master("local")
        .getOrCreate();

    // Reads a CSV file with header, called books.csv, stores it in a dataframe
    Dataset<Row> df = spark.read().format("json")
        .load("data/durham-nc-foreclosure-2006-2016.json");

    // Shows at most 5 rows from the dataframe
    df.show(5);
    df.printSchema();
  }
}
