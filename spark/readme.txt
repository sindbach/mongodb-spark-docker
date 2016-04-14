
# Run spark master - 1 node
${HOME}/spark-${SPARK_VERSION}-bin-hadoop${HADOOP_VERSION}/sbin/start-master.sh

# Run spark-shell 
${HOME}/spark-${SPARK_VERSION}-bin-hadoop${HADOOP_VERSION}/bin/spark-shell --jars ${HOME}/mongo-java-driver-${MONGO_JAVA_VERSION}.jar,${HOME}/mongo-hadoop-core-${MONGO_HADOOP_VERSION}.jar
