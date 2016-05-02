
# set data : You can run mongoimport on host to import into 'mongodb' docker instance
# to find out the IP on OSX docker-machine, you can use `docker-machine ip default`
mongoimport -h <mongodb ip> -d spark -c times ./times.json

# Run spark-shell 
${HOME}/spark-${SPARK_VERSION}-bin-hadoop${HADOOP_VERSION}/bin/spark-shell --jars ${HOME}/mongo-java-driver-${MONGO_JAVA_VERSION}.jar,${HOME}/mongo-hadoop-spark-${MONGO_HADOOP_VERSION}.jar

# Or you can run scala file through the shell by specifying `-i <file.scala>`
