package vn.edu.iuh.fit.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
