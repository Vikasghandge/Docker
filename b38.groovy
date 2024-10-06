pipeline {
    agent any

    tools {
        // Specify the SonarQube Scanner installation name defined in Jenkins Global Tool Configuration
        sonarQube 'SonarQube'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from your version control system (e.g., Git)
                git 'https://github.com/your-repository/your-project.git'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    // Running SonarQube analysis
                    withSonarQubeEnv('SonarQube') {
                        // Use Maven command for Java projects, or change this to match your build tool
                        sh 'mvn clean verify sonar:sonar'
                    }
                }
            }
        }
    }
}
