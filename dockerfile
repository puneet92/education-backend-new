# Use an official Java 11 image as the base image
FROM openjdk:8

RUN apt-get update && apt-get install -y maven

# Set the working directory to /app
WORKDIR /app

# Copy the pom.xml file into the container
COPY pom.xml .

# Build the project using Maven
RUN mvn clean package

# Copy the JAR file into the container
COPY target/*.jar app.jar

# Expose the port that the Spring Boot application will use
EXPOSE 8080

# Run the Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]