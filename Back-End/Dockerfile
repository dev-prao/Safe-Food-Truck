# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the build.gradle, settings.gradle and gradlew
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

# Give execution permissions to gradlew
RUN chmod +x gradlew

# Copy the gradle wrapper files
COPY gradle/wrapper/ ./gradle/wrapper/

# Download dependencies
RUN ./gradlew build

# Copy the project files
COPY . .

# Package the application
RUN ./gradlew bootJar

# Expose the port the application runs on
EXPOSE 8081

# Run the application
CMD ["java", "-jar", "build/libs/sft-0.0.1-SNAPSHOT.jar"]
