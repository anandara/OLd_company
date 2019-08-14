
import org.apache.spark.{ SparkConf, SparkContext }
import org.apache.spark.sql.functions.broadcast
import org.apache.spark.sql.types._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._


object wordcount extends App {
    
    val sc = new SparkContext(new SparkConf().setAppName("Spark Count").setMaster("local"))
    val sqlContext= new org.apache.spark.sql.SQLContext(sc)
    def doSomething(file: String) = {
 
 // your logic of processing a single file comes here
 
   val x = sc.textFile(file);
   val classMapper = x.map(line => (line.split(",")(0).split(",").flatMap(word => word), line.split(",")(0))).map(word => (word, 0)).reduceByKey(_ + _)
   val newrdd = classMapper.count()
   classMapper.saveAsTextFile("file:///C:\\Users\\681825\\Desktop\\Logfile")
  /* println(classMapper.collect().mkString(", "))
   println(classMapper.count()) 
  
   
 val dfsWordCount = x
      .flatMap(_.split(","))
      .filter(_.nonEmpty)
      .map(w => (w, 1))
      .countByKey()
      .values
      .sum
      println(dfsWordCount)

   
   
   val df = sqlContext.read
  .option("delimiter", ",")
  .option("header", false)
  .csv(file)
  .toDF("title", "text")
  
  println(df)
      
  */
 
}
    doSomething("file:///C:\\Users\\681825\\Desktop\\Logfile.txt")
}