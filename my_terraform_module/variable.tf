variable "ami_id" {
    description = "the ami id use for instance"
    type = string
}

variable "instance_type" {
    description = "type of instance"
    type = string
    default = "t2.micro"
}

variable "instance_name" {
    description = "the name of instance"
    
}