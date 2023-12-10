FROM openjdk:17-jdk-slim

ARG JAR_FILE=target/GateWay-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} GateWay-0.0.1-SNAPSHOT.jar

EXPOSE 8088

ENTRYPOINT ["java", "-jar", "/GateWay-0.0.1-SNAPSHOT.jar"]