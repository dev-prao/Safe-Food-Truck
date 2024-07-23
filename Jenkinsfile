pipeline {
    agent any
    environment {
        PROJECT_NAME = 'sft' // 프로젝트 이름
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'prao-test', url: 'https://github.com/Safe-Food-Truck-SSAFY-11th/Safe-Food-Truck.git'
            }
        }
        stage('Prepare') {
            steps {
                dir('Back-End') {
                    sh 'chmod +x gradlew' // gradlew에 실행 권한 부여
                }
            }
        }
        stage('Build') {
            steps {
                dir('Back-End') {
                    sh './gradlew clean build' // 빌드 수행
                    sh 'ls -al ./build' // 빌드 결과 확인
                }
            }
            post {
                success {
                    echo 'Gradle build success'
                }
                failure {
                    echo 'Gradle build failed'
                }
            }
        }
        stage('Test') {
            steps {
                dir('Back-End') {
                    sh './gradlew test'
                }
            }
        }
        stage('Deploy') {
            steps {
                dir('Back-End') {
                    sh 'nohup java -jar ./build/libs/sft-0.0.1-SNAPSHOT.jar > app.log 2>&1 &'
                }
            }
            post {
                success {
                    echo 'Spring Boot Run success'
                    sh 'sleep 10' // 서버가 시작될 시간을 줍니다.
                    sh 'tail -n 20 app.log' // 마지막 20줄의 로그를 출력합니다.
                    sh 'ss -tuln | grep 8081' // 포트 8081이 열려 있는지 확인합니다.
                }
                failure {
                    echo 'Spring Boot Run failed'
                }
            }
        }
    }
}
