package forum.bigapp.service.impl;

import forum.bigapp.model.User;
import forum.bigapp.repository.UserRepository;
import forum.bigapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public User save(User entity) {
        return repository.save(entity);
    }

    @Override
    public User getByID(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public User update(Long id, User entity) {
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll(); //TODO перевіряти isDeleted
    }

    @Override
    public void deleteById(Long id) {
        User user = getByID(id);
        user.setDeleted(true);
        update(id, user);
    }
}
