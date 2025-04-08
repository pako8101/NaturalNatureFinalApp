FROM ubuntu:latest
LABEL authors="Plamen Kamenov"

ENTRYPOINT ["top", "-b"]
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY . .
RUN ./gradlew clean build
CMD ["java", "-jar", "build/libs/NaturalNatureFinalApp-0.0.1-SNAPSHOT.jar"]
