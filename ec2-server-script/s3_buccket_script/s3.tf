resource "aws_s3_bucket" "example" {
  bucket = "my-tf-test-buckettt-"

  tags = {
    Name        = "My bucketttt-vikaspatil"
    Environment = "Dev"
  }
}