# Use a lightweight JRE image to run the application
FROM eclipse-temurin:17-jre

# Copy the built artifact from the build stage
COPY build/libs/*.jar app.jar

# Expose the application's port
EXPOSE 8080

# Default command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]