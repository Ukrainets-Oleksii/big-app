package forum.bigapp.service.impl;

import forum.bigapp.config.CookieUtil;
import forum.bigapp.model.Role;
import forum.bigapp.model.User;
import forum.bigapp.repository.UserRepository;
import forum.bigapp.security.jwt.JwtUtil;
import forum.bigapp.service.RoleService;
import forum.bigapp.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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

//    @Override
//    public User update(Long id, HttpServletRequest request, User entity) {
//        Cookie jwtCookie = CookieUtil.findJwtCookie(request);
//        String username = jwtUtil.getUsername(jwtCookie.getValue());
//        User user = findByUsername(username).get();
//
//        user.setEmail(entity.getEmail());
//        user.setUsername(entity.getUsername());
//        user.setPassword(entity.getPassword());
//        user.setDescription(entity.getDescription());
//
//        return repository.save(user);
//    }

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
