package vn.edu.iuh.fit.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
