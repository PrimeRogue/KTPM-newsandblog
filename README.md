# Nền tảng Tin tức và bài viết (News And Blog)

## Thành Viên Nhóm
- Bùi Trần Thiên Ân
- Nguyễn Phi Thiên

## Kiến Trúc Hệ Thống
Hệ thống bao gồm các service chính sau đây, được triển khai dựa trên kiến trúc microservices:

### 1. `authentication-service`
Sử dụng JWT để Xác thực (Authentication) và Phân quyền (Authorization) trong Spring Boot 3.0, dùng Spring Security 6 và MariaDB.
Các tính năng:
+ Thêm user mới với role là USER hoặc ADMIN, password được mã hoá.
+ Tạo token đăng nhập.

### 2. `redis-service`
Redis được sử dụng để lưu trữ dữ liệu cần được truy cập thường xuyên và nhanh chóng, nó không được dùng để lưu trữ dữ liệu lớn.

 
