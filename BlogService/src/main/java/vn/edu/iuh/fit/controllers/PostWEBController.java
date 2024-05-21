package vn.edu.iuh.fit.controllers;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.Post;
import vn.edu.iuh.fit.repositories.PostRepository;

import java.util.*;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostWEBController {
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
    // WEB: Lấy danh sách tất cả các bài viết
    @GetMapping("/posts")
    public String getAllPostsPage(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "post/posts";
    }

    // WEB: Xem chi tiết bài viết theo ID
    @GetMapping("/posts/{id}")
    public String findPostByIdPage(@PathVariable Long id, Model model) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            model.addAttribute("post", post.get());
            return "post/viewPost";
        } else {
            return "redirect:/post/posts";
        }
    }

    // WEB: Form thêm bài viết mới
    @GetMapping("/add")
    public String addNewPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "post/addPost";
    }

    // WEB: Xử lý thêm bài viết mới
    @PostMapping("/add")
    public String saveNewPost(@ModelAttribute Post post) {
        postRepository.save(post);
        return "redirect:/post/posts";
    }

    // WEB: Xóa bài viết theo ID
    @GetMapping("/posts/delete/{id}")
    public String deletePostByIdPage(@PathVariable Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
        }
        return "redirect:/post/posts";
    }



    // WEB: Tìm bài viết theo User ID
    @GetMapping("/posts/find-by-user/{userId}")
    public String findPostByUserIdPage(@PathVariable int userId, Model model) {
        List<Post> posts = postRepository.findPostByUserId(userId);
        if (posts.isEmpty()) {
            return "redirect:/post/posts?userNotFound";
        } else {
            model.addAttribute("posts", posts);
            return "post/postsByUser";
        }
    }

    @GetMapping("/retry")
    public String retryEndpoint(Model model) {
        HttpStatusCode httpStatusCode = randomStatus();
        if (HttpStatusCode.valueOf(200).isSameCodeAs(httpStatusCode)) {
            List<Post> posts = postRepository.findAll();
            model.addAttribute("posts", posts);
            return "post/posts";

        } else {
            model.addAttribute("httpStatusCode", httpStatusCode.value());
            return "post/error";
        }

    }
    private HttpStatusCode randomStatus() {
        int randomNumber = random.nextInt(statusCodes.size());
        return statusCodes.toArray(new HttpStatusCode[0])[randomNumber];
    }
}
