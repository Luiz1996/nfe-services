FROM eclipse-temurin:21-jdk-alpine

VOLUME /tmp

ARG JAR_FILE=target/app.jar

COPY ${JAR_FILE} app.jar

COPY application-docker.properties /app/config/application-docker.properties

ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-Dspring.config.additional-location=file:/app/config/", "-jar", "/app.jar"]
