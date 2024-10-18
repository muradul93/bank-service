
# Stage 1: Build the appconlication using Maven
FROM openjdk:17-jdk-slim AS build

# Set the working directory inside the container
WORKDIR /appcon

# Copy the Maven project files to the container
COPY . .

# Build the project using Maven, skipping tests
RUN ./mvnw clean package -DskipTests

# Stage 2: Create a lightweight image for the appconlication
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /appcon

# Copy the built JAR from the previous stage
COPY --from=build /appcon/target/config-server-0.0.1-SNAPSHOT.jar /appcon/config-server.jar

# Run the appconlication
ENTRYPOINT ["java", "-jar", "/appcon/config-server.jar"]