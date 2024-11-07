pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'ghandgevikas/my-docker-repo:b37'
        CONTAINER_NAME = 'container-1'
        SONAR_TOKEN = 'sqa_b9ff5dfd6c386a3b4b79e391c4e8e8d0937f6f1d'  // Your SonarQube token
        SONAR_HOST_URL = 'http://13.201.39.7:9000'  // Your SonarQube server URL
        SONAR_PROJECT_KEY = 'your_project_key' // Replace with your actual SonarQube project key
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

        stage('SonarQube Analysis') {
            steps {
                script {
                    echo 'Running SonarQube analysis...'
                    // You may need to mount the code directory for analysis
                    sh """
                    sonar-scanner \
                    -Dsonar.projectKey=${SONAR_PROJECT_KEY} \
                    -Dsonar.sources=. \
                    -Dsonar.host.url=${SONAR_HOST_URL} \
                    -Dsonar.login=${SONAR_TOKEN}
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

        // Uncomment to include a cleanup stage
        // stage('Cleanup') {
        //     steps {
        //         script {
        //             sh "/usr/bin/docker ps -a"  // Use full path to Docker for listing containers
        //         }
        //     }
        // }
    }
}
