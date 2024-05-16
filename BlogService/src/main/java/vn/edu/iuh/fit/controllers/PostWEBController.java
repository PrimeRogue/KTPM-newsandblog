package vn.edu.iuh.fit.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.Post;
import vn.edu.iuh.fit.repositories.PostRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostWEBController {
    private final PostRepository postRepository;

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
}
