# Use OpenJDK as the base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file into the container
COPY target/pet-app-0.1-SNAPSHOT.jar pet-app.jar

# Expose port 8080 (Spring Boot default)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "pet-app.jar"]
