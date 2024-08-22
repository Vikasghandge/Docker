resource "aws_instance" "example " {
 ami = var.ami.id
 instance_type = var.instance_type
 
}