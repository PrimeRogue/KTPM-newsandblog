package vn.edu.iuh.fit.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
