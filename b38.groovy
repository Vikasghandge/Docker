pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                // This stage is for building your project
                sh 'mvn clean verify'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                // SonarQube analysis using Maven
                withCredentials([string(credentialsId: 'sonarqube-token', variable: 'SONAR_TOKEN')]) {
                    sh """
                    mvn sonar:sonar \
                      -Dsonar.projectKey=my-project-key \
                      -Dsonar.host.url=http://13.235.33.149:9000 \
                      -Dsonar.login=${SONAR_TOKEN}
                    """
                }
            }
        }
    }
}
