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
