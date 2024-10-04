pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'ghandgevikas/my-docker-repo:traffic1'
        CONTAINER_NAME = 'container'
    }

    stages {
        stage('Pull Docker Image') {
            steps {
                script {
                    sh "/usr/bin/docker pull ${DOCKER_IMAGE}"  // Use full path to Docker
                }
            }
        }

        stage('Cleanup Existing Container') {
            steps {
                script {
                    // Stop and remove the existing container if it exists
                    sh """
                    if [ \$(docker ps -aq -f name=${CONTAINER_NAME}) ]; then
                        /usr/bin/docker stop ${CONTAINER_NAME}  // Use full path to Docker
                        /usr/bin/docker rm ${CONTAINER_NAME}    // Use full path to Docker
                    fi
                    """
                }
            }
        }

        stage('Deploy Docker Image') {
            steps {
                script {
                    sh """
                    /usr/bin/docker run -d --name ${CONTAINER_NAME} -p 80:80 ${DOCKER_IMAGE}  // Use full path to Docker
                    """
                }
            }
        }

        stage('Cleanup') {
            steps {
                script {
                    sh "/usr/bin/docker ps -a"  // Use full path to Docker for listing containers
                }
            }
        }
    }
}
