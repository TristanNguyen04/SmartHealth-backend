# Use official OpenJDK image
FROM openjdk:23-jdk-slim

# Set working directory
WORKDIR /app

# Copy JAR file to container
COPY target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
CMD ["java", "-Dlogging.level.root=DEBUG", "-jar", "/app/app.jar"]