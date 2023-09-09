# Use the official OpenJDK base image
FROM openjdk:11-jre-slim

# Metadata as a label
LABEL maintainer="your-email@example.com" \
      version="1.0" \
      description="Tennis League Spring Boot Application"

# The application's jar file
ARG JAR_FILE=target/tennisleague-1.0-SNAPSHOT.jar

# Add the application's jar to the container
COPY ${JAR_FILE} app.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","/app.jar"]
