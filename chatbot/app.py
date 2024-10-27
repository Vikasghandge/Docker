from flask import Flask, request, jsonify

app = Flask(__name__)

# Sample questions and answers
qa_pairs = {
    "What is DevOps?": "DevOps is a set of practices that combines software development (Dev) and IT operations (Ops).",
    "What are the key benefits of DevOps?": "Key benefits include faster delivery, improved collaboration, and higher efficiency.",
    "What is AWS?": "Amazon Web Services (AWS) is a comprehensive cloud platform offered by Amazon.",
    "What is the difference between AWS and Azure?": "AWS is known for its extensive services, while Azure offers strong integration with Microsoft tools.",
    "What is continuous integration?": "Continuous integration is a development practice where developers merge code changes frequently.",
    "What is continuous deployment?": "Continuous deployment automates the release of code changes to production after testing.",
    "What is Infrastructure as Code (IaC)?": "IaC is the process of managing and provisioning computing infrastructure through code.",
    "What are some popular IaC tools?": "Popular IaC tools include Terraform, AWS CloudFormation, and Ansible.",
    "What is Docker?": "Docker is a platform that enables developers to automate the deployment of applications in containers.",
    "What is Kubernetes?": "Kubernetes is an open-source platform for automating the deployment, scaling, and management of containerized applications.",
    "What is CI/CD?": "CI/CD stands for Continuous Integration and Continuous Deployment, aiming to automate the software release process.",
    "How do you monitor AWS resources?": "You can use AWS CloudWatch to monitor and log AWS resources and applications.",
    "What is AWS Lambda?": "AWS Lambda is a serverless compute service that runs your code in response to events.",
    "What is S3 used for?": "Amazon S3 is used for object storage, allowing you to store and retrieve any amount of data.",
    "What are VPCs in AWS?": "A Virtual Private Cloud (VPC) is a virtual network dedicated to your AWS account.",
    "What is AWS EC2?": "Amazon Elastic Compute Cloud (EC2) is a web service that provides resizable compute capacity in the cloud.",
    "What is CloudFormation?": "AWS CloudFormation is a service that helps you model and set up your Amazon Web Services resources.",
    "What are IAM roles?": "AWS Identity and Access Management (IAM) roles allow you to define permissions for AWS services.",
    "What is RDS?": "Amazon Relational Database Service (RDS) makes it easier to set up, operate, and scale a relational database.",
    "What is Elastic Beanstalk?": "Elastic Beanstalk is an easy-to-use service for deploying and scaling web applications and services.",
    "What is auto-scaling in AWS?": "Auto-scaling automatically adjusts the number of Amazon EC2 instances based on demand.",
    "What is a load balancer?": "A load balancer distributes incoming application traffic across multiple targets, like EC2 instances.",
    "What is AWS Route 53?": "Route 53 is a scalable Domain Name System (DNS) web service designed to route end users to internet applications.",
    "What are security groups in AWS?": "Security groups act as a virtual firewall for your EC2 instances to control inbound and outbound traffic.",
    "What is a Docker image?": "A Docker image is a lightweight, stand-alone, executable software package that includes everything needed to run a piece of software.",
    "What is a microservices architecture?": "Microservices architecture structures an application as a collection of loosely coupled services.",
    "What is a CI/CD pipeline?": "A CI/CD pipeline automates the steps of software delivery processes.",
    "What is the purpose of version control systems?": "Version control systems track changes to code over time, enabling collaboration among developers.",
    "What is Jenkins?": "Jenkins is an open-source automation server that supports building, deploying, and automating software development.",
    "What is monitoring and logging?": "Monitoring is observing the state of a system, while logging is the practice of collecting and storing logs of events.",
    "What is serverless architecture?": "Serverless architecture allows you to build and run applications without managing server infrastructure."
}

# @app.route('/chat', methods=['POST'])
@app.route('/chat', methods=['POST'])

def chat():
    user_message = request.json.get('message')
    response = qa_pairs.get(user_message, "I'm sorry, I don't understand that question.")
    return jsonify({'reply': response})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)
