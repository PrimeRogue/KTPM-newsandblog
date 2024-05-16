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
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private String roles;
}
