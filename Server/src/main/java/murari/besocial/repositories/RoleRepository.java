package murari.besocial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import murari.besocial.domain.entities.UserRole;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, String> {
    UserRole findByAuthority(String authority);

    UserRole getByAuthority(String authority);
}
