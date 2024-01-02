package forum.bigapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String description;
//    @OneToMany(mappedBy = "owner")
    @OneToMany
    private List<Comment> comments;
//    @OneToMany(mappedBy = "owner")
    @OneToMany
    private List<Topic> topics;
}