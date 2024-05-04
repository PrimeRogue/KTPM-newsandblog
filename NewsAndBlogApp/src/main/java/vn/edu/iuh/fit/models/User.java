package vn.edu.iuh.fit.models;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@Table(name = "User")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String username;
    private String password;
    private String email;

}
