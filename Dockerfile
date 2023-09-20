FROM ubuntu:latest
FROM maven:latest AS stage1
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:resolve
COPY . /app
RUN mvn clean
RUN mvn package -DskipTests
FROM openjdk:20 as final
COPY ./target/bilyzna1-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar","app.jar"]
