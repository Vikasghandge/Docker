provider "aws" {
    region = "ap-south-1"
}

resource "aws_instance" "example" {
    ami = "value"
    instance_type = "value"
    
}