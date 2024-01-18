package forum.bigapp.service;

import forum.bigapp.model.User;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface UserService extends GenericService<User> {
    User saveAdmin(User user);

    Optional<User> findByEmail(String email);

    Long getIdFromJwtToken(HttpServletRequest request);

    Optional<User> findByUsername(String username);
}
