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
        stage('Deploy Prepare') {
            steps {
                sh 'sudo kill $(pgrep -f sft || true' // 실행 중인 프로세스가 없을 경우 오류 무시
            }
        }
        stage('Deploy') {
            steps {
                dir('Back-End') {
                    sh 'nohup java -jar ./build/libs/sft-0.0.1-SNAPSHOT.jar &'
                }
            }
        }
    }
}
