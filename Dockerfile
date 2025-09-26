FROM eclipse-temurin:24

LABEL maintainer="student@example.com"
LABEL description="MySpringBootApp Spring Boot Microservice"
LABEL version="1.0"

# Install unzip and curl for debugging
RUN apt-get update && apt-get install -y unzip curl

WORKDIR /app

COPY target/MySpringBootApp-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "/app/app.jar"]