# variables.tf
variable "ami" {
  description = "The AMI ID for the EC2 instance."
  type        = string
}

variable "instance_type" {
  description = "The type of EC2 instance."
  type        = string
}

variable "key_name" {
  description = "The key pair name for SSH access."
  type        = string
}
