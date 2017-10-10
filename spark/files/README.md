
### Setting Data 

You can run use `initDocuments.scala` to import using Spark itself.

```
spark-shell --conf "spark.mongodb.input.uri=mongodb://mongodb:27017/spark.times" --conf "spark.mongodb.output.uri=mongodb://mongodb/spark.output" --packages org.mongodb.spark:mongo-spark-connector_${SCALA_VERSION}:${MONGO_SPARK_VERSION} -i ./initDocuments.scala
```

#### Run spark-shell 

```
spark-shell --conf "spark.mongodb.input.uri=mongodb://mongodb:27017/spark.times" --conf "spark.mongodb.output.uri=mongodb://mongodb/spark.output" --packages org.mongodb.spark:mongo-spark-connector_${SCALA_VERSION}:${MONGO_SPARK_VERSION}
```

Alternatively you can run scala file through the shell by specifying `-i <file.scala>`. For example to run `examples.scala` example: 

```
spark-shell --conf "spark.mongodb.input.uri=mongodb://mongodb:27017/spark.times" --conf "spark.mongodb.output.uri=mongodb://mongodb/spark.output" --packages org.mongodb.spark:mongo-spark-connector_${SCALA_VERSION}:${MONGO_SPARK_VERSION} -i ./examples.scala 
```

### start 1 master/worker
```
${SPARK_HOME}/sbin/start-master.sh
${SPARK_HOME}/sbin/start-slave.sh spark://spark:7077
```
