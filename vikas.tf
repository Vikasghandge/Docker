provider "aws" {
    region = "ap-south-1"
}

resource "aws_instance" "server_1"{
    ami = ""
    instance_type = "t2.micro"
    key_name = "devops-key"
    tags = {
        name = "my_ec2"
    }

}