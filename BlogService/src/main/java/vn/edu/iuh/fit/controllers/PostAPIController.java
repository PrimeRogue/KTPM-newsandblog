package vn.edu.iuh.fit.controllers;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.Post;
import vn.edu.iuh.fit.repositories.PostRepository;

import java.util.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostAPIController {
    private final PostRepository postRepository;
    private Set<HttpStatusCode> statusCodes;
    private Random random;

    @PostConstruct
    void init() {
        statusCodes = new HashSet<>();
        statusCodes.add(HttpStatusCode.valueOf(200));
        statusCodes.add(HttpStatusCode.valueOf(400));
        statusCodes.add(HttpStatusCode.valueOf(408));
        statusCodes.add(HttpStatusCode.valueOf(500));
        statusCodes.add(HttpStatusCode.valueOf(503));

        random = new Random();
    }
    // REST API: Get all posts
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return ResponseEntity.ok(posts);
    }

    // REST API: Get post by ID
    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable Long id) {
        Optional<Post> post = postRepository.findById(id);
        return post.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // REST API: Add a new post
    @PostMapping("/add")
    public ResponseEntity<Post> addNewPost(@RequestBody Post post) {
        Post savedPost = postRepository.save(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }

    // REST API: Delete post by ID
    @DeleteMapping("/posts/delete/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // REST API: Get posts by User ID
    @GetMapping("/posts/find-by-user/{userId}")
    public ResponseEntity<List<Post>> findPostByUserId(@PathVariable int userId) {
        List<Post> posts = postRepository.findPostByUserId(userId);
        if (posts.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(posts);
        }
    }

    @GetMapping("/retry")
    ResponseEntity<String> retryEndpoint() {
        HttpStatusCode httpStatusCode = randomStatus();
        if (HttpStatusCode.valueOf(200).isSameCodeAs(httpStatusCode)) {
            return new ResponseEntity<>("Request Success: " + httpStatusCode, httpStatusCode);
        } else {
            return new ResponseEntity<>("Request Failure: " + httpStatusCode, httpStatusCode);
        }
    }
    private HttpStatusCode randomStatus() {
        int randomNumber = random.nextInt(statusCodes.size());
        return statusCodes.toArray(new HttpStatusCode[0])[randomNumber];
    }
}
