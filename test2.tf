provider "aws" {
    region = "ap-south-1"
}
resource "aws_instance" "my_instance" {
    ami = "value"
    
    
}