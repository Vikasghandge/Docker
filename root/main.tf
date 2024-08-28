module "vpc" {
    source = "../modules/vpc"
    project_name = var.project_name
   vpc_cidr =  var.pub_sub_1a_cidr
   vpc_cidr = var.pub_sub_2b_cidr 
   vpc_cidr = var.pri_sub_3a_cidr 
   vpc_cidr = var.pri_sub_4b_cidr 
   vpc_cidr = var.pri_sub_5a_cidr 
   vpc_cidr = var.pri_sub_6b_cidr = 
}