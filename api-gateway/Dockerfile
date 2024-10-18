
# Stage 1: Build the appgwlication using Maven
FROM openjdk:17-jdk-slim AS build

# Set the working directory inside the container
WORKDIR /appgw

# Copy the Maven project files to the container
COPY . .

# Build the project using Maven, skipping tests
RUN ./mvnw clean package -DskipTests

# Stage 2: Create a lightweight image for the appgwlication
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /appgw

# Copy the built JAR from the previous stage
COPY --from=build /appgw/target/api-gateway-0.0.1-SNAPSHOT.jar /appgw/api-gateway.jar

# Run the appgwlication
ENTRYPOINT ["java", "-jar", "/appgw/api-gateway.jar"]