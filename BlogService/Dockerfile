# Đặt tên file là BlogService/Dockerfile

FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/blog-service.jar blog-service.jar

EXPOSE 9092

ENTRYPOINT ["java", "-jar", "blog-service.jar"]
