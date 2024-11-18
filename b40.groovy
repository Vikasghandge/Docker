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
                sh 'docker build -t season_switcher_image ./traffic_light'
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
