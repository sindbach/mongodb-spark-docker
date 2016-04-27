# Docker for MongoDB and Apache Spark. 

An example of docker-compose to set up a single [Apache Spark](http://spark.apache.org/) node connecting to [MongoDB](https://www.mongodb.com/) via [MongoDB Connector for Hadoop](https://docs.mongodb.org/ecosystem/tools/hadoop/)

### Starting up 

You can start by running command : 

```
docker-compose run spark bash
```

Which would run the spark node and the mongodb node, and provides you with bash shell for the spark. 

From the spark instance, you could reach the MongoDB instance using `mongodb` hostname. 

You can find a small dataset example in `/home/ubuntu/times.json` which you could load into the mongodb instance.

As an example, please take a look at `reduceByKey.scala` to query from mongodb, run a simple aggregation, and finally write out back to mongodb.


### More Information. 

See related article:

* [MongoDB Hadoop use cases ](https://docs.mongodb.org/ecosystem/use-cases/hadoop/)

* [MongoDB Blog: aggregating intervals of stock prices](https://www.mongodb.com/blog/post/using-mongodb-hadoop-spark-part-1-introduction-setup)

* [MongoDB Radio: Hadoop connector with Luke Lovett](https://soundcloud.com/mongodb/hadoop-connector-with-luke-lovett)

* [In development: MongoDB Spark Connector](https://github.com/mongodb/mongo-spark)
