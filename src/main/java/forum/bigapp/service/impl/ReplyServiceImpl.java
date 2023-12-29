package forum.bigapp.service.impl;

import forum.bigapp.model.Reply;
import forum.bigapp.repository.ReplyRepository;
import forum.bigapp.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private ReplyRepository repository;
    @Override
    public Reply save(Reply entity) {
        return repository.save(entity);
    }

    @Override
    public Reply getByID(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Reply update(Reply entity) {
        return null;
    }

    @Override
    public List<Reply> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

