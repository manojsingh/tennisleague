# Use the official OpenJDK base image
FROM openjdk:11-jre-slim

# Metadata as a label
LABEL maintainer="singhs.manoj@gmail.com" \
      version="1.0" \
      description="Tennis League Spring Boot Application"


# Create directory where logs will be stored
RUN mkdir -p /var/log

# The application's jar file
ARG JAR_FILE=target/tennisleague-1.0-SNAPSHOT.jar

# Add the application's jar to the container
COPY ${JAR_FILE} tennisleagueapp.jar

EXPOSE 8080

# Run the jar file 
ENTRYPOINT ["java","-jar","/tennisleagueapp.jar"]
