<<<<<<< HEAD
# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the build.gradle and gradle wrapper
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

# Download dependencies
RUN ./gradlew build -x test --parallel --continue --refresh-dependencies

# Copy the project files
COPY . .

# Package the application
RUN ./gradlew bootJar

# Expose the port the application runs on
EXPOSE 5000

# Run the application
CMD ["java", "-jar", "build/libs/safefoodtruck-0.0.1-SNAPSHOT.jar"]
=======
FROM openjdk:17-jdk
ARG JAR_FILE=build/libs/sft-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} sft-springboot.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/sft-springboot.jar"]
>>>>>>> 3cf26bbae4a6750606e0a2038c97b6ae9c725194
