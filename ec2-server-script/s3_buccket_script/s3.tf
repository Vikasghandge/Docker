resource "aws_s3_bucket" "example" {
  bucket = "my-tf-test-bucketttvikaspatil"

  tags = {
    Name        = "My bucketttt-vikaspatil"
    Environment = "Dev"
  }
}


resource "aws_s3_bucket" "demo" {
    bucket = "dmobuccketuniq"

tags = {
    Name = "demo-buccket"
    Environment
}    
}