package vn.edu.iuh.fit.models;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@Table(name = "Category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String categoryName;
}
