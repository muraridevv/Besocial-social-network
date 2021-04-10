package murari.besocial.services;

import murari.besocial.domain.entities.UserRole;

public interface RoleService {
    boolean persist(UserRole role) throws Exception;

    UserRole getByName(String name);
}
