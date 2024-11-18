pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clone the repository
                git branch: 'main', url: 'https://github.com/Vikasghandge/Docker.git'
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    // Specify the path to the Dockerfile
                    sh 'docker build -t season_switcher_image ./season_switcher'
                }
            }
        }
    }
}



