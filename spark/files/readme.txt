
# set data : You can run mongoimport on host to import into 'mongodb' docker instance
# to find out the IP on OSX docker-machine, you can use `docker-machine ip default`
mongoimport -h <mongodb ip> -d spark -c times ./times.json

# Or  you can just use initDocuments.scala to import using Spark itself
${SPARK_HOME}/bin/spark-shell --conf "spark.mongodb.input.uri=mongodb://mongodb:27017/spark.times" --conf "spark.mongodb.output.uri=mongodb://mongodb/spark.output" --packages org.mongodb.spark:mongo-spark-connector_2.10:1.0.0 -i ./initDocuments.scala

# Run spark-shell 
${SPARK_HOME}/bin/spark-shell --conf "spark.mongodb.input.uri=mongodb://mongodb:27017/spark.times" --conf "spark.mongodb.output.uri=mongodb://mongodb:27107/spark.output" --packages org.mongodb.spark:mongo-spark-connector_${SCALA_VERSION}:${MONGO_SPARK_VERSION}

# Or you can run scala file through the shell by specifying `-i <file.scala>`

# start 1 master/worker
${SPARK_HOME}/sbin/start-master.sh
${SPARK_HOME}/sbin/start-slave.sh spark://spark:7077