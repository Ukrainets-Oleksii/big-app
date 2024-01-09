package forum.bigapp.service;

import forum.bigapp.model.Role;

public interface RoleService extends GenericService<Role> {
    Role getByRoleName(Role.RoleName roleName);
}
