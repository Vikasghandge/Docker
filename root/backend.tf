terraform {
  backend "s3" {
    bucket = "tfstate-piyush-101"
    key    = "backend/10weeksofcloudops-demo.tfstate"
    region = "ap-south-1"
    dynamodb_table = "remote-backend"
  }
}