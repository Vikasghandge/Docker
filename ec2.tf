resource "aws_instance" "server_1"{
    ami = "ami-0ad21ae1d0696ad58"
    instance_type = "t2.micro"
    key_name = "devops-key"
    tags = {
        name = "my_ec2"
    }

}