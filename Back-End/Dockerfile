# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the build.gradle and gradle wrapper
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

# Give execution permissions to gradlew
RUN chmod +x gradlew

# Download dependencies
RUN ./gradlew build -x

# Copy the project files
COPY . .

# Package the application
RUN ./gradlew bootJar

# Expose the port the application runs on
EXPOSE 8081

# Run the application
CMD ["java", "-jar", "build/libs/safefoodtruck-0.0.1-SNAPSHOT.jar"]
