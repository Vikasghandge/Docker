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



------------------------------------------------------------------------------------------------------------------------

pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Vikasghandge/Docker.git'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t season_switcher_image ./season_switcher'
            }
        }

        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh '''
                        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                        docker tag season_switcher_image $DOCKER_USER/season_switcher_image:latest
                        docker push $DOCKER_USER/season_switcher_image:latest
                    '''
                }
            }
        }
    }
}
