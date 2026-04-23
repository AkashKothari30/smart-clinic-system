# ----------- Stage 1: Build the application -----------
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy all project files
COPY . .

# Build the jar file (skip tests for faster build)
RUN mvn clean package -DskipTests


# ----------- Stage 2: Run the application -----------
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]