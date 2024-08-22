# office
demo repo
# EC2 Module

This module provisions an AWS EC2 instance.

## Inputs

- `ami`: The AMI ID for the instance.
- `instance_type`: The type of EC2 instance.
- `key_name`: The key pair name for SSH access.

## Outputs

- `instance_id`: The ID of the EC2 instance.
- `public_ip`: The public IP of the EC2 instance.
