# Đặt tên file là RegistryService/Dockerfile

FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/registry-service.jar registry-service.jar

EXPOSE 8088

ENTRYPOINT ["java", "-jar", "registry-service.jar"]
