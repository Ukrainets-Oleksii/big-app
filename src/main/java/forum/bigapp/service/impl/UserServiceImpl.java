package forum.bigapp.service.impl;

import forum.bigapp.model.Role;
import forum.bigapp.model.User;
import forum.bigapp.repository.UserRepository;
import forum.bigapp.service.RoleService;
import forum.bigapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final RoleService roleService;

    @Override
    public User save(User entity) {
        Role role = new Role();
        role.setRoleName(Role.RoleName.ADMIN);
        roleService.save(role);
        entity.addRole(role);
        return repository.save(entity);
    }

    @Override
    public User getByID(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public User update(Long id, User entity) {
        User user = getByID(id);
        user.setEmail(entity.getEmail());
        user.setUsername(entity.getUsername());
        user.setPassword(entity.getPassword());
        user.setDescription(entity.getDescription());

        return repository.save(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        User user = getByID(id);
        user.setDeleted(true);
        update(id, user);
    }
}
