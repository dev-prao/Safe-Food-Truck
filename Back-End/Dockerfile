# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Package the application
RUN ./gradlew bootJar

COPY build/libs/sft-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the application runs on
EXPOSE 8081

# Run the application
CMD ["java", "-jar", "build/libs/app.jar"]
