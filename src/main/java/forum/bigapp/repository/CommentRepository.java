package forum.bigapp.repository;

import forum.bigapp.model.Comment;
import forum.bigapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentsByOwner(User user);
}
