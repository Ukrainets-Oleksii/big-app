package forum.bigapp.service;

import forum.bigapp.model.User;
import java.util.Optional;

public interface UserService extends GenericService<User> {
    Optional<User> findByEmail(String email);
}
