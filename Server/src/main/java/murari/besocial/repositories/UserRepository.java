package murari.besocial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import murari.besocial.domain.entities.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

    User findAllByFirstName(String firstName);

    Optional<User> findByUsername(String username);

    @Query(value = "" +
            "SELECT u FROM User AS u " +
            "WHERE u.id <> :id AND " +
            "(LOWER(u.firstName) LIKE CONCAT('%', :searchSymbols, '%') OR " +
            "LOWER(u.lastName) LIKE CONCAT('%', :searchSymbols, '%'))  ")
    List<User> findAllUsersLike(@Param(value = "id") String id,
                                   @Param(value = "searchSymbols") String searchSymbols);

    @Transactional
    @Modifying
    @Query(value = "Update User as u " +
            "SET u.online = false " +
            "WHERE u.online = true ")
    void setIsOnlineToFalse();
}
