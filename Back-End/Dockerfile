FROM openjdk:17-jdk
ARG JAR_FILE=build/libs/sft-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} sft-springboot.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/sft-springboot.jar"]