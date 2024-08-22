# modules/ec2/main.tf
resource "aws_instance" "my_ec2" {
  ami           = var.ami
  instance_type = var.instance_type
  key_name       = var.key_name

  tags = {
    Name = "MyEC2Instance"
  }
}
