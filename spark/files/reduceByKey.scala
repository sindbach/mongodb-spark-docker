import org.apache.hadoop.conf.Configuration

import com.mongodb.hadoop.io.BSONWritable;

import com.mongodb.hadoop.MongoInputFormat;

import org.bson.BSONObject
import org.bson.BasicBSONObject
import org.joda.time.DateTime

/*
 For example, if you have 4 documents of :

{ "doc": "A", "timestamp" : ISODate("2016-02-15T00:43:04.686Z"), "RID" : 1 }
{ "doc": "B", "timestamp" : ISODate("2016-02-15T00:43:06.310Z"), "RID" : 2 }
{ "doc": "C", "timestamp" : ISODate("2016-01-03T00:43:07.534Z"), "RID" : 1 }
{ "doc": "D", "timestamp" : ISODate("2016-01-03T00:43:09.214Z"), "RID" : 2 }

Grouping by `myid` sort latest timestamp, would return only two documents, doc:A and doc:B. 
Removing duplicates of myid’s by returning only documents with the latest timestamp.
*/

val mongoConfig = new Configuration()
mongoConfig.set("mongo.input.uri", "mongodb://mongodb:27017/spark.times")
mongoConfig.set("mongo.input.query", "{'myid':{$in:[1,2,3,4,5]}}")
mongoConfig.set("mongo.input.sort", "{timestamp:-1}")

val documents = sc.newAPIHadoopRDD(mongoConfig, classOf[MongoInputFormat], classOf[Object], classOf[BSONObject])

val outputRDD = documents.map(
            (tuple)=>((tuple._2.get("myid")), (tuple._2.get("timestamp")))
             ).reduceByKey((x, y) => if (new DateTime(x).isAfter(new DateTime(y))) x else y ).map(
            (tuple)=>{val bson = new BasicBSONObject(); 
                  bson.put("myid", tuple._1); 
                  bson.put("timestamp", tuple._2); 
                  (null, bson)
                  }
        )

outputRDD.foreach(println)

val outputConfig = new Configuration()
outputConfig.set("mongo.output.uri", "mongodb://mongodb:27017/spark.output")

// write out result
outputRDD.saveAsNewAPIHadoopFile("file:///x", classOf[Any], classOf[Any], classOf[com.mongodb.hadoop.MongoOutputFormat[Any, Any]], outputConfig)


System.exit(0);
