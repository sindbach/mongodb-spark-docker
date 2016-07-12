
/* Load the content of times.json and load into the database to initiate data */
import com.mongodb.spark._
import com.mongodb.spark.config._
import org.bson.Document 

val rdd = MongoSpark.load(sc)

if (rdd.count<1){
    val t = sc.textFile("times.json")
    val converted = t.map((tuple)=>Document.parse(tuple))
    converted.saveToMongoDB(WriteConfig(Map("uri"->"mongodb://mongodb/spark.times")))
    println("Documents inserted.")
} else {
    println("Database 'spark' collection 'times' is not empty. Maybe you've loaded a data into the collection previously ? skipping process. ")
}
System.exit(0);
