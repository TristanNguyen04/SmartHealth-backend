# Use official OpenJDK image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy JAR file to container
COPY target/SmartHealth-backend-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
CMD ["java", "-Dlogging.level.root=DEBUG", "-jar", "/app/app.jar"]