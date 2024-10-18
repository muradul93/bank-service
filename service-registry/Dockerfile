# Stage 1: Build the application using Maven
FROM openjdk:17-jdk-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files to the container
COPY . .

# Build the project using Maven, skipping tests
RUN ./mvnw clean package -DskipTests

# Stage 2: Create a lightweight image for the application
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR from the previous stage
COPY --from=build /app/target/service-registry-0.0.1-SNAPSHOT.jar /app/service-registry.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app/service-registry.jar"]
