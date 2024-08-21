resource "aws_vpc" "my-vpc" {
    cidr_block = "10.0.0.0/16"

}

resource "aws_subnet" "public" {
    vpc_id = vpc_id.public.id 
    cidr_block = 192.168.0.0/24
    tags = {
        name = "my_vpc"
    }
}

resource "aws_subnet" "private" {
    vpc_id = vpc_id.private.vpc_id
    cidr_block = 192.168.1.0/24
    tags = {
        name = "my-private"
    }
}

resource "awa_inter"  {}