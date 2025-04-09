FROM ubuntu:latest
LABEL authors="Plamen Kamenov"
FROM openjdk:17-jdk-alpine

# Дефинираме работната директория
WORKDIR /app
RUN java -version

# Копираме всички файлове от локалната директория в Docker контейнера
COPY . .

# Настройваме правата на gradlew
RUN chmod +x gradlew


# 🛑 Стъпка 5: Спри Gradle от сваляне на toolchains
ENV ORG_GRADLE_PROJECT_javaToolchainDownload=false
# Стартираме build процеса с gradlew
RUN ./gradlew clean build -x test --stacktrace

# Добави инсталация на Gradle, ако е необходимо
RUN apk add --no-cache gradle

# Стартираме приложението чрез JAR файл
CMD ["java", "-jar", "build/libs/NaturalNatureFinalApp-0.0.1-SNAPSHOT.jar"]

#ENTRYPOINT ["top", "-b"]
#FROM openjdk:17-jdk-alpine
#WORKDIR /app
#COPY . .
#RUN ./gradlew clean build
#CMD ["java", "-jar", "build/libs/NaturalNatureFinalApp-0.0.1-SNAPSHOT.jar"]
