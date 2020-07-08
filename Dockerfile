#FROM openjdk:8-jre
#WORKDIR /app
#VOLUME ["/app"]
#COPY maven/app.jar app.jar
#COPY maven/start.sh start.sh
#COPY maven/wait-for-it.sh wait-for-it.sh
#RUN sh -c 'touch app.jar'
#ENTRYPOINT ["./start.sh"]
FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
RUN mvn -B dependency:go-offline -f /tmp/pom.xml -s /usr/share/maven/ref/settings-docker.xml
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn -B -s /usr/share/maven/ref/settings-docker.xml package

FROM java:8-jre-alpine

EXPOSE 8080

ENV MONGO_PORT 27017

RUN mkdir /app
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/*.jar /app/app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]
