FROM eclipse-temurin:24

LABEL maintainer="student@example.com"
LABEL description="MySpringBootApp Spring Boot Microservice"
LABEL version="1.0"

# Install unzip and curl for debugging
RUN apt-get update && apt-get install -y unzip curl

WORKDIR /app

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "/app/app.jar"]