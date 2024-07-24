FROM openjdk:17-alpine

WORKDIR /app

# 로컬 파일을 컨테이너로 복사
COPY . /app

# 현재 디렉토리의 파일 목록을 로그로 찍기
RUN ls -al

RUN chmod +x gradlew

RUN ./gradlew clean build -x test

ARG JAR_FILE=/build/libs/sft-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} /app.jar

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod", "/app.jar"]