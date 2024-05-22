# Đặt tên file là ApiGateway/Dockerfile

# Sử dụng một image chính thức của Maven để xây dựng
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Sao chép file pom.xml và tải các dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Sao chép mã nguồn và biên dịch
COPY src ./src
RUN mvn clean package -DskipTests

# Sử dụng một image chính thức của OpenJDK để chạy ứng dụng
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/api-gateway.jar api-gateway.jar

# Khai báo cổng sẽ được expose
EXPOSE 9090

# Command để chạy ứng dụng
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]
