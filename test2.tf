provider "aws" {
    region = "value"
}
resource "aws_instance" "my-ec2" {
    ami = "value"
    instance_type = "value"
    
}
output "ec2-output" {
    value = aws_instance.my-ec2.id
  
}