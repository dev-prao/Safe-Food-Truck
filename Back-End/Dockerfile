FROM openjdk:17-alpine

RUN pwd

RUN chmod +x gradlew

RUN ./gradlew clean build -x test

ARG JAR_FILE=/build/libs/sft-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} /app.jar

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod", "/app.jar"]