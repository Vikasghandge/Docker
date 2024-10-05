pipeline {
    agent any 

    environment {
        SONAR_TOKEN = credentials('SONAR_TOKEN') // Jenkins credentials ID for SonarQube token
        DOCKER_IMAGE = 'ghandgevikas/my-docker-repo:todo' // Your Docker image name
        DOCKER_REGISTRY = 'your_docker_registry' // Replace with your Docker registry URL
    }

    stages {
        stage('Build') {
            steps {
                script {
                    // Build the Docker image
                    sh "docker build -t ${DOCKER_IMAGE} ."
                }
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                script {
                    // Run SonarQube analysis
                    sh "sonar-scanner -Dsonar.projectKey=your_project_key -Dsonar.sources=. -Dsonar.host.url=http://your_sonarqube_url -Dsonar.login=${SONAR_TOKEN}"
                }
            }
        }

        stage('Docker Push') {
            steps {
                script {
                    // Log in to the Docker registry
                    sh "docker login -u your_username -p your_password ${DOCKER_REGISTRY}" // Use Jenkins credentials here
                    // Push the Docker image
                    sh "docker push ${DOCKER_IMAGE}"
                }
            }
        }
        
        // Add other stages if necessary...
    }
}
