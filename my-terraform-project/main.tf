module "example_instance" {
    source = "./my-terraform-module"

    ami_id = "ami-0522ab6e1ddcc7055"
    instance_type = "t2.micro"
    instance_name = "my-example-instance"
    
}