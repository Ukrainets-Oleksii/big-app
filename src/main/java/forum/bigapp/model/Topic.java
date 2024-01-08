package forum.bigapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Table(name = "topics")
@Where(clause = "is_deleted = false")
@Data
@NoArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String timestamp;
    @Column(name = "is_deleted", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean isDeleted;
    @ManyToOne
    private User owner;
//    @OneToMany(mappedBy = "topic")
    @OneToMany
    private List<Comment> comments;

    public Topic(Long id) {
        this.id = id;
    }
}
