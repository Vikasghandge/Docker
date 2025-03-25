resource "aws_s3_bucket" "demo" {
    bucket = "pohebuccket_dhiraj"
    
    tags = {
      "name" = "value"
    }
}