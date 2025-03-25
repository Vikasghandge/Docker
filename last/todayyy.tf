provider "aws" {
  region = "ap-south-1"  # Correct AWS region (Mumbai)
}

resource "aws_instance" "my_new_instance" {  # Fixed resource name
  ami           = "ami-0e35ddab05955cf57"  # Ensure this AMI exists in ap-south-1
  instance_type = "t2.micro"

  tags = {
    Name = "Terraform-EC2"
  }
}

variable "" {
}