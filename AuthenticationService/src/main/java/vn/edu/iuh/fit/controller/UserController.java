package vn.edu.iuh.fit.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import vn.edu.iuh.fit.model.AuthRequest;
import vn.edu.iuh.fit.model.UserInfo;
import vn.edu.iuh.fit.service.JwtService;
import vn.edu.iuh.fit.service.RedisService;
import vn.edu.iuh.fit.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

  @Autowired
  private UserInfoService service;

  @Autowired
  private JwtService jwtService;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private RedisService redisService;

  @GetMapping("/welcome")
  public String welcome() {
    return "Welcome this endpoint is not secure";
  }

//  @PostMapping("/addNewUser")
//  public String addNewUser(@RequestBody UserInfo userInfo) {
//    return service.addUser(userInfo);
//  }

  @PostMapping("/addNewUser")
  public ResponseEntity<String> addNewUser(@RequestBody UserInfo userInfo) {
    if (userInfo.getEmail() == null || userInfo.getName() == null || userInfo.getRoles() == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email, name, or roles cannot be null.");
    } else {
      return ResponseEntity.ok(service.addUser(userInfo));
    }
  }

  @GetMapping("/login/user")
  @PreAuthorize("hasAuthority('ROLE_USER')")
  public String userProfile() {
    return "Welcome to User Profile";
  }

  @GetMapping("/login/admin")
  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  public String adminProfile() {
    return "Welcome to Admin Profile";
  }

  @PostMapping("/generateToken")
  public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
    if (authentication.isAuthenticated()) {
      String token = jwtService.generateToken(authRequest.getUsername());
      redisService.saveToken(authRequest.getUsername(), token); // Lưu token vào Redis
      return token;
    } else {
      throw new UsernameNotFoundException("invalid user request !");
    }
  }
}
