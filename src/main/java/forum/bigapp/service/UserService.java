package forum.bigapp.service;

import forum.bigapp.model.User;
import java.util.Optional;

public interface UserService extends GenericService<User> {
    User saveAdmin(User user);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);
}
