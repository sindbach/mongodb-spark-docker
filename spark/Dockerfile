FROM ubuntu:16.04

RUN apt-get update -y && apt-get install -y \
default-jdk \
nano \
wget && \
apt-get clean && \
rm -rf /var/lib/apt/lists/*

RUN useradd --create-home --shell /bin/bash ubuntu

ENV HOME /home/ubuntu
ENV SPARK_VERSION 2.1.1
ENV HADOOP_VERSION 2.6
ENV MONGO_SPARK_VERSION 2.0.0
ENV SCALA_VERSION 2.11

WORKDIR ${HOME}

ENV SPARK_HOME ${HOME}/spark-${SPARK_VERSION}-bin-hadoop${HADOOP_VERSION}
ENV PATH ${PATH}:${SPARK_HOME}/bin

COPY files/times.json /home/ubuntu/times.json
COPY files/readme.txt /home/ubuntu/readme.txt
COPY files/examples.scala /home/ubuntu/examples.scala
COPY files/initDocuments.scala /home/ubuntu/initDocuments.scala

RUN chown -R ubuntu:ubuntu /home/ubuntu/*
USER ubuntu

# get spark
RUN wget http://apache.mirror.digitalpacific.com.au/spark/spark-${SPARK_VERSION}/spark-${SPARK_VERSION}-bin-hadoop${HADOOP_VERSION}.tgz && \
tar xvf spark-${SPARK_VERSION}-bin-hadoop${HADOOP_VERSION}.tgz

RUN rm -fv spark-${SPARK_VERSION}-bin-hadoop${HADOOP_VERSION}.tgz

