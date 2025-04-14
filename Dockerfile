FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/portfolio_website-0.0.1-SNAPSHOT.jar portfolio_website.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "portfolio_website.jar"]