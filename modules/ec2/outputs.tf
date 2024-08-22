# modules/ec2/outputs.tf
output "instance_id" {
  description = "The ID of the EC2 instance."
  value       = aws_instance.my_ec2.id
}

output "public_ip" {
  description = "The public IP of the EC2 instance."
  value       = aws_instance.this.public_ip
}
