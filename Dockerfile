FROM openjdk

EXPOSE 8090

COPY target/yorick-1.0-SNAPSHOT.jar /

CMD java -jar /yorick-1.0-SNAPSHOT.jar
