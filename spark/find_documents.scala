
import org.apache.hadoop.conf.Configuration
import org.bson.BSONObject
import com.mongodb.hadoop.MongoInputFormat

val mongoConfig = new Configuration()
mongoConfig.set("mongo.input.uri", "mongodb://mongodb:27017/mug.spark")
mongoConfig.set("mongo.input.query", "{'foo':{$in:[1,2]}}")
mongoConfig.set("mongo.input.sort", "{_id:-1}")

val documents = sc.newAPIHadoopRDD(mongoConfig, classOf[MongoInputFormat], classOf[Object], classOf[BSONObject])
documents.foreach(println)
documents.count()
