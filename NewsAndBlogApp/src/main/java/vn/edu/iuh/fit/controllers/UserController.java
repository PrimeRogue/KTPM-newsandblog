package vn.edu.iuh.fit.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.User;
import vn.edu.iuh.fit.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    // Lấy danh sách tất cả user
    @GetMapping("/getListUsers")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    // Thêm user
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        // Trả về response với user đã được lưu và HTTP status OK (200)
        return ResponseEntity.status(HttpStatus.OK).body(savedUser);
    }
    // Tìm user theo ID
    @GetMapping("/users/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId) {
        return userRepository.findById(userId);
    }
}