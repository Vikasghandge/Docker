resource "aws_s3_bucket" "demo" {
    bucket = "pohebuccketdhiraj"
    
    tags = {
      "name" = "s3-buccket-today"
    }
}