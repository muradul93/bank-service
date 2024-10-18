
# Stage 1: Build the apptrslication using Maven
FROM openjdk:17-jdk-slim AS build

# Set the working directory inside the container
WORKDIR /apptrs

# Copy the Maven project files to the container
COPY . .

# Build the project using Maven, skipping tests
RUN ./mvnw clean package -DskipTests

# Stage 2: Create a lightweight image for the apptrslication
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /apptrs

# Copy the built JAR from the previous stage
COPY --from=build /apptrs/target/transaction-service-0.0.1-SNAPSHOT.jar /apptrs/transaction-service.jar

# Run the apptrslication
ENTRYPOINT ["java", "-jar", "/apptrs/transaction-service.jar"]