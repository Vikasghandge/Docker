##set up for jenkin and sonarkube intregration
first of all create one ec2 server.
select t2.medium this is good. and attach storage above 20gb
take ssh launch instance and take ssh of your ec2 instance.
install docker in your ec2.
```
# Add Docker's official GPG key:
sudo apt-get update
sudo apt-get install ca-certificates curl
sudo install -m 0755 -d /etc/apt/keyrings
sudo curl -fsSL https://download.docker.com/linux/ubuntu/gpg -o /etc/apt/keyrings/docker.asc
sudo chmod a+r /etc/apt/keyrings/docker.asc
                                                      ```



# Add the repository to Apt sources:

```
echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.asc] https://download.docker.com/linux/ubuntu \
  $(. /etc/os-release && echo "$VERSION_CODENAME") stable" | \
  sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
sudo apt-get update
                        ```




```
sudo apt-get install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
                                                                                                         ```
                                                                                                         
                                                                                                         
                                                                                                         
                                                                                                         
  now verify docker installed on your ec2 instance 
  ```
            docker --version
                                  ```


                                  
now docker has been sucessfully installed on your ec2
now need to install sonarqube on your ec2
here are running sonarqube using docker container so for that run give command




``` docker run -d --name sonar -p 9000:9000 sonarqube:lts-community 
 ```




                    ## given command will run sonar qube container on your ec2 
        check using command




        ```
              docker ps 
                                ```



###now take your local hostip address and ex localhost:9000

it will open interface
login user name     admin
password            admin



go to the quality profile select java name is custom

create your custom project name this prject generate its creadential 

like this 

sh '''
                            mvn clean verify sonar:sonar \
                            -Dsonar.projectKey=sonar-project \
                            -Dsonar.host.url=${SONAR_HOST_URL} \
                            -Dsonar.login=${SONAR_LOGIN}
                        '''









       #this is simple pimple example ##

       ```
       pipeline {
    agent {
        docker {
            image 'maven:3.8.5-jdk-11'
            args '-v /root/.m2:/root/.m2'
        }
    }

    environment {
        SONAR_HOST_URL = 'http://13.126.98.111:9000'
        SONAR_LOGIN = 'sqp_7512ec630ea51e940a126573e9a0b3c9c53fd56f'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Vikasghandge/Docker.git', branch: 'main'
            }
        }

        stage('Build and SonarQube Analysis') {
            steps {
                dir('my-project') {
                    script {
                        sh '''
                            mvn clean verify sonar:sonar \
                            -Dsonar.projectKey=sonar-project \
                            -Dsonar.host.url=${SONAR_HOST_URL} \
                            -Dsonar.login=${SONAR_LOGIN}
                        '''
                    }
                }
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'my-project/target/*.jar', allowEmptyArchive: true
            }
        }
    }

    post {
        success {
            echo 'Build and SonarQube analysis succeeded!'
        }
        failure {
            echo 'Build or SonarQube analysis failed.'
        }
    }
}


```


pipline should be like this


go to genkins dashboard manage configuration
make sure maven should be installed on your ec2 insatnce

go to new project select pipeline
add your pipline and repo url sonarkube credits.
apply and save then build.


