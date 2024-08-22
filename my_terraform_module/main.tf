
provider "aws" {
   region = "ap-south-1"
}


# resource "aws_instance" "example" {
#  ami = var.ami.id
#  instance_type = var.instance_type
#  tags =  {
#     name = var.instance_name
#  }
# }

module "example_instance" {
   source = ""
   
}