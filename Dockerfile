# Use a lightweight Java 17 environment
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file we just built into the container
COPY target/SpringBoot_CRUD-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8081

# Command to execute when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]