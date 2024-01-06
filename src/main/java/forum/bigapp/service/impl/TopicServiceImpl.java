package forum.bigapp.service.impl;

import forum.bigapp.model.Topic;
import forum.bigapp.model.User;
import forum.bigapp.repository.TopicRepository;
import forum.bigapp.service.TopicService;
import forum.bigapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {
    private final TopicRepository repository;
    private final UserService userService;

    @Override
    public Topic save(Topic entity) {
        Topic topic = repository.save(entity);
        setTopicToUser(entity);
        return topic;
    }

    @Override
    public Topic getByID(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Topic update(Topic entity) {
        return repository.save(entity);
    }

    @Override
    public List<Topic> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        getByID(id).setDeleted(true);
    }

    private void setTopicToUser(Topic entity){
        User user = userService.getByID(entity.getOwner().getId());
        user.getTopics().add(entity);
        userService.update(user);
    }
}
