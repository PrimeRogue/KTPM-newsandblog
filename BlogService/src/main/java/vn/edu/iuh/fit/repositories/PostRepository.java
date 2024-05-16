package vn.edu.iuh.fit.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostByUserId(int user_id);
}
