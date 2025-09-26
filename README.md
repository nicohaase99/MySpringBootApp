
Project Overview:
This project is a simple Spring Boot web application for a Pet Clinic, allowing users to manage owner, pet, and appointment data through a web interface. It uses Thymeleaf for server-side templating and is packaged as a runnable JAR file. The application is containerized using Docker, integrated with Jenkins for CI/CD, and deployed on an AWS EC2 instance. To access the project, just clone my github repo:

https://github.com/nicohaase99/MySpringBootApp.git

1. Build the Application
Ensure Java 24 and Maven are installed.
To build the application, run:
mvn clean package

The generated JAR will be located at:
target/MySpringBootApp-0.0.1-SNAPSHOT.jar


2. Dockerize the Application
Build the Docker Image:
docker build -t my-springboot-app .

Run the Docker Container:
docker run -d -p 9090:9090 my-springboot-app


3. Deploy on AWS EC2
Launch and Configure EC2 Instance:
Start a new EC2 instance.


In the Security Group, allow inbound access on ports:


22 (SSH)


80, 443 (HTTP/HTTPS)


8080, 9090 (Application)


Install Docker on EC2:
SSH into the instance and run:
sudo yum install docker -y
sudo service docker start
sudo usermod -aG docker ec2-user
newgrp docker

Transfer and Run the App:
Copy the JAR file or Docker image to the EC2 instance.


Build or run the Docker container as shown above.


Access the application at:
http://<EC2-PUBLIC-DNS>:9090/


4. Install Jenkins Using Docker
Pull Jenkins Image:
docker pull jenkins/jenkins:lts

Prepare Jenkins Data Directory:
sudo mkdir -p /var/jenkins_home
sudo chown 1000:1000 /var/jenkins_home

Run Jenkins Container:
docker run -d \
  --name jenkins \
  -p 8080:8080 \
  -p 50000:50000 \
  -v /var/jenkins_home:/var/jenkins_home \
  jenkins/jenkins:lts


5. Jenkins CI/CD Pipeline
Use a Jenkinsfile in the project root to define your pipeline.


The pipeline should:


Build the application using Maven


Run tests


Package the application as a JAR


Build and deploy the Docker image


Perform a health check on the endpoint /health

Thank you for using my application!
