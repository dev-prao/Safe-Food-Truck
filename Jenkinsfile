pipeline {
    agent {
        docker {
            image 'docker:latest'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }
    environment {
        PROJECT_NAME = 'sft' // 프로젝트 이름
        DOCKER_IMAGE = 'sft-back'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'test', url: 'https://github.com/Safe-Food-Truck-SSAFY-11th/Safe-Food-Truck.git'
            }
        }
        stage('Docker Build') {
            steps {
                dir('Back-End') {
                    script {
                        sh 'docker build -t ${DOCKER_IMAGE} .'
                    }
                }
            }
            post {
                success {
                    echo 'Docker build success'
                }
                failure {
                    echo 'Docker build failed'
                    error 'Stopping pipeline'
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    // Stop any running instance
                    sh '''
                    if [ $(docker ps -q -f name=${PROJECT_NAME}) ]; then
                        echo "Stopping running instance"
                        docker stop ${PROJECT_NAME}
                        docker rm ${PROJECT_NAME}
                    fi
                    '''

                    // Run the new instance
                    sh 'docker run -d --name ${PROJECT_NAME} -p 8080:8080 -v back_home:/var/lib ${DOCKER_IMAGE}'
                }
            }
            post {
                success {
                    echo 'Docker container run success'
                }
                failure {
                    echo 'Docker container run failed'
                    sh 'docker logs ${PROJECT_NAME}'
                }
            }
        }
    }
}
