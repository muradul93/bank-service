
# Stage 1: Build the appaclication using Maven
FROM openjdk:17-jdk-slim AS build

# Set the working directory inside the container
WORKDIR /appac

# Copy the Maven project files to the container
COPY . .

# Build the project using Maven, skipping tests
RUN ./mvnw clean package -DskipTests

# Stage 2: Create a lightweight image for the appaclication
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /appac

# Copy the built JAR from the previous stage
COPY --from=build /appac/target/account-service-0.0.1-SNAPSHOT.jar /appac/account-service.jar

# Run the appaclication
ENTRYPOINT ["java", "-jar", "/appac/account-service.jar"]