FROM openjdk:17-alpine

WORKDIR /app

RUN pwd

# 로컬 파일을 컨테이너로 복사
COPY . .

# 현재 디렉토리의 파일 목록을 로그로 찍기
RUN echo "파일 목록:" && ls -al

RUN chmod +x gradlew

RUN ./gradlew clean build -x test

# 빌드 후 파일 목록 출력
RUN echo "빌드 후 파일 목록:" && ls -al build/libs

ARG JAR_FILE=build/libs/sft-0.0.1-SNAPSHOT.jar

RUN pwd

COPY ${JAR_FILE} /app.jar

# JAR 파일이 제대로 복사되었는지 확인
RUN echo "복사된 JAR 파일 확인:" && ls -al /app.jar

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod", "/app.jar"]