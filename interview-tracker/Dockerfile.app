
# Use an official OpenJDK runtime as a parent image
FROM amazoncorretto:17-alpine-jdk

# Set the working directory to /app
WORKDIR /app

# Now copy the built jar to app
COPY ./target/*.jar app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Specify the command to run on container start
CMD ["java", "-jar", "app.jar"]