package forum.bigapp.service.impl;

import forum.bigapp.config.Config;
import forum.bigapp.model.Topic;
import forum.bigapp.model.User;
import forum.bigapp.repository.TopicRepository;
import forum.bigapp.service.TopicService;
import forum.bigapp.service.UserService;
import forum.bigapp.service.manager.EmotionsManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {
    private final TopicRepository repository;
    private final UserService userService;
    private final EmotionsManager<Topic> emotionsManager;

    @Override
    public Topic save(Topic entity) {
        entity.setTimestamp(LocalDateTime.now().format(Config.format));
        Topic topic = repository.save(entity);
        setTopicToUser(entity);
        return topic;
    }

    @Override
    public Topic getByID(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public List<Topic> findTopicsByOwner(User user) {
        return repository.getTopicsByOwner(user);
    }

    //TODO how to get topic for add emotion
    @Override
    public void doEmotion(Long topicId, String username) {
        Topic topic = getByID(topicId);
        emotionsManager.doEmotion(topic, username); //TODO!!!!!!!!!!
        topic.setCountOfEmotions(
                emotionsManager.getCountOfEmotionsForEntity(topic));
        update(topicId, topic);
    }

    @Override
    public Topic update(Long id, Topic update) {
        Topic topic = getByID(id);
        setFlag(topic, update);
        topic.setContent(update.getContent());
        return repository.save(topic);
    }

    @Override
    public List<Topic> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        Topic topic = getByID(id);
        topic.setDeleted(true);
        update(id, topic);
    }

    private void setTopicToUser(Topic entity){
        User user = userService.getByID(entity.getOwner().getId());
        user.getTopics().add(entity);
        userService.update(user.getId(), user);
    }

    //TODO
    private void setFlag(Topic entity, Topic update) {
        if (!(entity.getContent().equals(update.getContent()))) {
            entity.setFlagEditedContent(true);
        }
    }
}
