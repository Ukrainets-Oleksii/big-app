package forum.bigapp.service.impl;

import forum.bigapp.model.Comment;
import forum.bigapp.repository.CommentRepository;
import forum.bigapp.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private CommentRepository repository;

    @Override
    public Comment save(Comment entity) {
        return repository.save(entity);
    }

    @Override
    public Comment getByID(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Comment update(Comment entity) {
        return repository.save(entity);
    }

    @Override
    public List<Comment> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
