
# Use an official OpenJDK runtime as a parent image
FROM amazoncorretto:17-alpine-jdk

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
# Install Apache Maven 3.9.6
#ENV MAVEN_VERSION 3.9.6
#ENV MAVEN_HOME /usr/lib/mvn
#ENV PATH $MAVEN_HOME/bin:$PATH
#
#RUN wget -q "https://downloads.apache.org/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz" -O /tmp/apache-maven.tar.gz \
#    && tar -xzf /tmp/apache-maven.tar.gz -C /usr/lib/ \
#    && ln -s /usr/lib/apache-maven-$MAVEN_VERSION $MAVEN_HOME \
#    && rm -f /tmp/apache-maven.tar.gz

# Copies the current directory to /app workdir
#COPY . .
#RUN rm -rf target
#RUN mvn clean install -U -DskipTests

# Now copy the built jar to app
COPY ./target/*.jar app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Specify the command to run on container start
CMD ["java", "-jar", "app.jar"]