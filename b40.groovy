pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building the application...'
                sh 'make build'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'make test'
            }
        }
    }

    post {
        success {
            echo 'Build and Test completed successfully!'
        }
        failure {
            echo 'Build and Test failed.'
        }
    }
}
