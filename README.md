# Docker for MongoDB and Apache Spark. 

An example of docker-compose to set up a single [Apache Spark](http://spark.apache.org/) node connecting to [MongoDB](https://www.mongodb.com/) via [MongoDB Connector for Hadoop](https://docs.mongodb.org/ecosystem/tools/hadoop/)

### Starting up 

You can start by running commang : 

```
docker-compose run spark bash
```

Which would run the spark node and the mongodb node, and provides you with bash shell for the spark. 

From the spark instance, you could reach the MongoDB instance using `mongodb` hostname. 



### More Information. 

See related article:

* [Using MongoDB with Hadoop and Spark: Part 1 - Introduction and Setup](https://www.mongodb.com/blog/post/using-mongodb-hadoop-spark-part-1-introduction-setup)

