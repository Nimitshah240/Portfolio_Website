# Step 1: Build the project using Maven
FROM maven:3.8.5-openjdk-17 AS build

# Set working directory inside the container
WORKDIR /portfolio_website

# Copy all project files into the container
COPY . .

# Package the application without running tests
RUN mvn clean package -DskipTests

# Step 2: Run the app using a slim JDK image
FROM openjdk:17-slim

# Set working directory
WORKDIR /portfolio_website

# Copy the built jar file from the build stage
# COPY --from=build /portfolio_website/target/portfolio_website-0.0.1-SNAPSHOT.jar portfolio_website.jar
COPY --from=build /portfolio_website/target/Portfolio_Website-0.0.1-SNAPSHOT.jar portfolio_website.jar


# Expose the port your app listens on
EXPOSE $PORT

# Start the application
ENTRYPOINT ["java", "-jar", "portfolio_website.jar"]