package forum.bigapp.repository;

import forum.bigapp.model.Topic;
import forum.bigapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> getTopicsByOwner(User user);
}
