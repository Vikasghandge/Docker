resource "aws_vpc" "my-vpc" {
    cidr_block = "10.0.0.0/16"

}

resource "aws_subnet" "public" {
    vpc_id = aws_vpc.my_vpc.id
    cidr_block = "10.0.1.0/24"
    tags = {
        name = "my_public_subnet"
    }
}

resource "aws_subnet" "private" {
    vpc_id = aws_vpc.my_vpc.id
    cidr_block = "10.0.2.0/24"
    tags = {
        name = "my-private"
    }
}

resource "aws_internet_gateway" "igw"  {
    vpc_id = vpc_id.public.vpc_id

}