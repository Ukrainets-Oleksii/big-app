package forum.bigapp.service.impl;

import forum.bigapp.model.Role;
import forum.bigapp.repository.RoleRepository;
import forum.bigapp.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Override
    public Role save(Role entity) {
        return repository.save(entity);
    }

    @Override
    public Role getByID(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Role getByRoleName(Role.RoleName roleName) {
        return repository.getByRoleName(roleName);
    }

    @Override
    public Role update(Long id, Role entity) {
        Role role = getByID(id);
        role.setDeleted(entity.getDeleted());

        return repository.save(entity);
    }

    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        Role role = getByID(id);
        role.setDeleted(true);
        update(id, role);
    }
}
