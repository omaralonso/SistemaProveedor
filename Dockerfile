# fetch basic  image
FROM openjdk:8-jdk-alpine
# application placed into /opt/app
RUN mkdir -p /opt/app
WORKDIR /opt/app
# rest of the project
COPY target /opt/app/target
# local application port
EXPOSE 8080
# execute it
CMD ["sh", "-c", "java -jar -Dhttp.keepalive=false /opt/app/target/ms-usuario-rest-0.0.1-SNAPSHOT.jar"]
