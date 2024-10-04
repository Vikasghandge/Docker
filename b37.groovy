pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'ghandgevikas/my-docker-repo:todo'
        CONTAINER_NAME = 'my-container'
    }

    stages {
        stage('Pull Docker Image') {
            steps {
                script {
                    sh "docker pull ${DOCKER_IMAGE}"
                }
            }
        }

        stage('Cleanup Existing Container') {
            steps {
                script {
                    // Stop and remove the existing container if it exists
                    sh """
                    if [ \$(docker ps -aq -f name=${CONTAINER_NAME}) ]; then
                        docker stop ${CONTAINER_NAME}
                        docker rm ${CONTAINER_NAME}
                    fi
                    """
                }
            }
        }

        stage('Deploy Docker Image') {
            steps {
                script {
                    sh """
                    docker run -d --name ${CONTAINER_NAME} -p 8081:8080 ${DOCKER_IMAGE}
                    """
                }
            }
        }

        stage('Cleanup') {
            steps {
                script {
                    sh "docker ps -a"  // List running containers for confirmation
                }
            }
        }
    }
}
