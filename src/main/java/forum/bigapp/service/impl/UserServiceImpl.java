package forum.bigapp.service.impl;

import forum.bigapp.exception.DataProcessingException;
import forum.bigapp.model.Role;
import forum.bigapp.model.User;
import forum.bigapp.repository.UserRepository;
import forum.bigapp.security.jwt.JwtUtil;
import forum.bigapp.service.RoleService;
import forum.bigapp.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final RoleService roleService;
    private final JwtUtil jwtUtil;

    @Override
    public User save(User entity) {
        return repository.save(entity);
    }

    @Override
    public User saveAdmin(User user) {
        user.getRoles().add(roleService.getByRoleName(Role.RoleName.ADMIN));
        return repository.save(user);
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
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
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

    @Override
    public Long getIdFromJwtToken(HttpServletRequest request) {
        String token = Arrays.stream(request.getCookies())
                .filter(e -> e.getName().equals("jwtToken"))
                .map(Cookie::getValue)
                .findFirst()
                .orElse(null);

        String username = jwtUtil.getUsername(token);

        User user = findByUsername(username)
                .orElseThrow(() -> new DataProcessingException(
                        "Can't find user by username: " + username));

        return user.getId();
    }
}
