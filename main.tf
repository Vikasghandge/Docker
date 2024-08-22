# main.tf
provider "aws" {
  region = "ap-south-1"
}

module "ec2_instance" {
  source        = "./modules/ec2"
  ami           = var.ami
  instance_type = var.instance_type
  key_name       = var.key_name
}

output "instance_id" {
  value = module.ec2_instance.instance_id
}

output "public_ip" {
  value = module.ec2_instance.public_ip
}
# main.tf
provider "aws" {
  region = "ap-south-1"
}

module "ec2_instance" {
  source        = "./modules/ec2"
  ami           = var.ami
  instance_type = var.instance_type
  key_name       = var.key_name
}

output "instance_id" {
  value = module.ec2_instance.instance_id
}

output "public_ip" {
  value = module.ec2_instance.public_ip
}