package forum.bigapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "replies")
@Where(clause = "is_deleted = false")
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String timestamp;
    private int countOfEmotions;
    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    private boolean flagEditedContent;
    @Column(name = "is_deleted", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean isDeleted;
    @ManyToOne
    private User owner;
    @ManyToOne
    private Comment headComment;

    public Reply(Long id) {
        this.id = id;
    }
}
