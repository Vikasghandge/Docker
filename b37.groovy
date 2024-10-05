pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'ghandgevikas/my-docker-repo:b37'
        CONTAINER_NAME = 'container-1'
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
                        /usr/bin/docker stop ${CONTAINER_NAME}  
                        /usr/bin/docker rm ${CONTAINER_NAME}    
                    fi
                    """
                }
            }
        }

        stage('Deploy Docker Image') {
            steps {
                script {
                    sh """
                    /usr/bin/docker run -d --name ${CONTAINER_NAME} -p 80:80 ${DOCKER_IMAGE}  
                    """
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'SONAR_TOKEN', variable: 'SONAR_TOKEN')]) {
                        // Use the official SonarQube scanner Docker image
                        sh """
                        /usr/bin/docker run --rm \
                        -e SONAR_HOST_URL=http://your-sonarqube-server:9000 \
                        -e SONAR_LOGIN=\${SONAR_TOKEN} \
                        sonarsource/sonar-scanner-cli:latest \
                        -Dsonar.projectKey=your_project_key \
                        -Dsonar.sources=your_source_code_directory
                        """
                    }
                }
            }
        }
    }
}
