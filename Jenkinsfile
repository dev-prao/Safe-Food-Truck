pipeline {
    agent any
    environment {
        PROJECT_NAME = 'sft' // 프로젝트 이름
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'test', url: 'https://github.com/Safe-Food-Truck-SSAFY-11th/Safe-Food-Truck.git'
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
                    sh 'ls -al ./build/libs'
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
                    sh 'nohup java -jar ./build/libs/sft-0.0.1-SNAPSHOT.jar --server.port=8081 &'
                }
            }
            post {
                success {
                    echo 'Spring Boot Run success'
                }
                failure {
                    echo 'Spring Boot Run failed'
                }
            }
        }
    }
}
