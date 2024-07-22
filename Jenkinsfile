pipeline{
    agent any
    stages {
            stage('Checkout') {
                steps {
                    git branch: 'test', url: 'https://github.com/Safe-Food-Truck-SSAFY-11th/Safe-Food-Truck.git'
                }
            }

            stage('Build') {
                steps {
                    sh './gradlew clean build'
                }
            }

            stage('Docker Build') {
                steps {
                    script {
                        dockerImage = docker.build("${env.DOCKER_IMAGE}")
                    }
                }
            }

            stage('Docker Run') {
                steps {
                    script {
                        dockerImage.run('-p 8080:8080')
                    }
                }
            }
        }
}
