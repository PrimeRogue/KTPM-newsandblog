# Nền tảng Tin tức và bài viết (News And Blog)

## Thành Viên Nhóm
- Bùi Trần Thiên Ân
- Nguyễn Phi Thiên


## Run Application

### `1. Run các Service`
+ BlogService (port: 9092)
+ UserService (port: 9091)
+ AuthenticationService
+ ApiGateway (port: 9090)

### `2. Điều hướng cổng với Apigateway`
+ Gateway sẽ chuyển các port khác (9091, 9092, ...) thành cùng 1 port là 9090.
+ Ví dụ:
http://localhost:9092/api/post/posts được chuyển thành http://localhost:9090/api/post/posts 
http://localhost:9091/api/user/users được chuyển thành http://localhost:9090/api/user/users


### `3. Xem Api document với Swagger UI`
+ Swagger UI là một Api document cho các Service.
+ Sau khi run BlogService, bạn có thể truy cập http://localhost:9092/swagger-ui/index.html để xem Api document của BlogService.


### `4. Authentication Service với JWT`
+ Tạo user mới
  ![.](demo-images/add-new-user.PNG)
+ Tạo token để đăng nhập
  ![.](demo-images/generate-token.PNG)
+ Đăng nhập với quyền ADMIN
  ![.](demo-images/login-admin.PNG)


### `5. Lưu token với Redis database`
+ Setup Redis cho Window:
   https://www.youtube.com/watch?v=DLKzd3bvgt8

+ Mở 1 tab cmd, run command line "redis-server" để start Redis
  ![.](demo-images/redis-server.PNG)
+ Run AuthenticationService Project
+ Mở Postman
  POST: http://localhost:8080/auth/generateToken
  Body --> raw --> JSON: {"username": "anshul", "password": "123"}
  ![.](demo-images/redis-postman.PNG)
+ Mở 1 tab cmd khác, run command line "redis-cli", chạy các lệnh như hình:
  ![.](demo-images/redis-client.PNG)


