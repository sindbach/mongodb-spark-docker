FROM ubuntu:14.04

RUN apt-get update -y && apt-get install -y \
openjdk-7-jre-headless \
nano \
wget && \
apt-get clean && \
rm -rf /var/lib/apt/lists/*

RUN useradd --create-home --shell /bin/bash ubuntu 

ENV HOME /home/ubuntu
ENV SPARK_VERSION 1.6.1
ENV HADOOP_VERSION 2.6
ENV MONGO_HADOOP_VERSION 1.5.2
ENV MONGO_JAVA_VERSION 3.2.2

WORKDIR ${HOME}

COPY files/times.json /home/ubuntu/times.json
COPY files/readme.txt /home/ubuntu/readme.txt
COPY files/reduceByKey.scala /home/ubuntu/reduceByKey.scala
RUN chown -R ubuntu:ubuntu /home/ubuntu/* 
USER ubuntu 

# get spark 
RUN wget http://apache.mirror.digitalpacific.com.au/spark/spark-${SPARK_VERSION}/spark-${SPARK_VERSION}-bin-hadoop${HADOOP_VERSION}.tgz && \
tar xvf spark-${SPARK_VERSION}-bin-hadoop${HADOOP_VERSION}.tgz

RUN rm -fv spark-${SPARK_VERSION}-bin-hadoop${HADOOP_VERSION}.tgz

# get mongo-hadoop 
RUN wget -O mongo-hadoop-spark-${MONGO_HADOOP_VERSION}.jar http://search.maven.org/remotecontent?filepath=org/mongodb/mongo-hadoop/mongo-hadoop-spark/${MONGO_HADOOP_VERSION}/mongo-hadoop-spark-${MONGO_HADOOP_VERSION}.jar

# get mongo java driver
RUN wget http://central.maven.org/maven2/org/mongodb/mongo-java-driver/3.2.2/mongo-java-driver-${MONGO_JAVA_VERSION}.jar