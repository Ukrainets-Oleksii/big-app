package forum.bigapp.service.impl;

import forum.bigapp.model.Topic;
import forum.bigapp.model.User;
import forum.bigapp.repository.TopicRepository;
import forum.bigapp.service.TopicService;
import forum.bigapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {
    private final TopicRepository repository;
    private final UserService userService;

    @Override
    public Topic save(Topic entity) {
        entity.setTimestamp(String.valueOf(LocalDate.now()));
        Topic topic = repository.save(entity);
        setTopicToUser(entity);
        return topic;
    }

    @Override
    public Topic getByID(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Topic update(Long id, Topic entity) {
        entity.setId(id);
        return repository.save(entity);
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
}
