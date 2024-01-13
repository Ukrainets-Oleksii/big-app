package forum.bigapp.service;

import forum.bigapp.model.Topic;
import forum.bigapp.model.User;
import java.util.List;

public interface TopicService extends GenericService<Topic> {
    List<Topic> findTopicsByOwner(User user);
}
