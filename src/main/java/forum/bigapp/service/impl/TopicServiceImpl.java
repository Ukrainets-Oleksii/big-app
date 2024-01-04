package forum.bigapp.service.impl;

import forum.bigapp.model.Topic;
import forum.bigapp.repository.TopicRepository;
import forum.bigapp.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {
    private TopicRepository repository;

    @Override
    public Topic save(Topic entity) {
        return repository.save(entity);
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
}
