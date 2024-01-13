package forum.bigapp.repository;

import forum.bigapp.model.Reply;
import forum.bigapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findRepliesByOwner(User user);
}