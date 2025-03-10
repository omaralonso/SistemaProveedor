FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn install

FROM openjdk:8-jdk-alpine
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/accessing-data-mysql-0.0.1-SNAPSHOT.jar accessing-data-mysql-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["sh", "-c", "java -jar -Dhttp.keepalive=false accessing-data-mysql-0.0.1-SNAPSHOT.jar"]
