package murari.besocial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import murari.besocial.domain.entities.Like;
import murari.besocial.domain.entities.Post;
import murari.besocial.domain.entities.User;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, String> {
    Like findByUserAndPost(User user, Post post);

    List<Like> findAllByPost(Post post);
}
