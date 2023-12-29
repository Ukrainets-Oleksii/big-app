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
    private UserRepository repository;

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public User getByID(Long id) {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
