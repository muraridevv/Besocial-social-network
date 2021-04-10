package murari.besocial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import murari.besocial.domain.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {
}
