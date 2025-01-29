# Use OpenJDK as the base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file into the container
COPY target/pet-app-0.0.1-SNAPSHOT.jar pet-app.jar

# Expose port 8080 (Spring Boot default)
EXPOSE 8080

RUN echo "127.0.0.1 ec2-18-200-50-100.eu-west-1.compute.amazonaws.com" >> /etc/hosts

ENV AWS_REGION=eu-west-1
ENV AWS_INSTANCE_ID=i-0abcdef1234567890
ENV AWS_PUBLIC_IP=18.200.50.100

RUN useradd -m ec2-user
USER ec2-user

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "pet-app.jar"]
