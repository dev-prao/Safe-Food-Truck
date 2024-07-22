pipeline{
    agent any
    environment {
        PROJECT_NAME = 'safe-food-truck' // 프로젝트 이름
    }
    stages{
        stage('Checkout') {
            steps {
                git branch: 'test', url: 'https://github.com/Safe-Food-Truck-SSAFY-11th/Safe-Food-Truck.git'
            }
        }
        stage('Prepare'){
            steps {
                dir('Back-End') {
                    sh 'chmod +x ./gradlew'
                    sh './gradlew clean'
                }
            }
        }
        stage('Build') {
            steps {
                dir('Back-End') {
                    sh './gradlew build -x test'
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
        stage('Deploy Prepare'){
            steps {
                sh 'sudo kill $(pgrep -f ${PROJECT_NAME})'
            }
        }
        stage('Deploy') {
            steps {
                dir('Back-End') {
                    sh 'nohup java -jar ./build/libs/${PROJECT_NAME}.jar &'
                }
            }
        }
    }
}
