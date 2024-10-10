# Dockerfile
FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/service-registry-0.0.1-SNAPSHOT.jar service-registry.jar
ENTRYPOINT ["java","-jar","/service-registry.jar"]