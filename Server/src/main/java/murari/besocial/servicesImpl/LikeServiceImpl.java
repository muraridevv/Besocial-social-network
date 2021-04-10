package murari.besocial.servicesImpl;

import static murari.besocial.utils.constants.ResponseMessageConstants.FAILURE_POST_LIKE_MESSAGE;
import static murari.besocial.utils.constants.ResponseMessageConstants.SERVER_ERROR_MESSAGE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import murari.besocial.domain.entities.Like;
import murari.besocial.domain.entities.Post;
import murari.besocial.domain.entities.User;
import murari.besocial.repositories.LikeRepository;
import murari.besocial.repositories.PostRepository;
import murari.besocial.repositories.UserRepository;
import murari.besocial.services.LikeService;
import murari.besocial.utils.responseHandler.CustomException;
import murari.besocial.validations.serviceValidation.services.PostValidationService;
import murari.besocial.validations.serviceValidation.services.UserValidationService;

@Service
@Transactional
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final UserValidationService userValidation;
    private final PostValidationService postValidation;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository, PostRepository postRepository, UserRepository userRepository, UserValidationService userValidation, PostValidationService postValidation) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.userValidation = userValidation;
        this.postValidation = postValidation;
    }

    @Override
    public boolean addLike(String postId, String loggedInUserId) throws Exception {
        Post post = this.postRepository.findById(postId).orElse(null);
        User user = this.userRepository.findById(loggedInUserId).orElse(null);

        if (!postValidation.isValid(post) || !userValidation.isValid(user)) {
            throw new Exception(SERVER_ERROR_MESSAGE);
        }

        Like likeByUserAndPost = this.likeRepository.findByUserAndPost(user, post);

        if (likeByUserAndPost == null) {
            Like like = new Like();
            like.setUser(user);
            like.setPost(post);
            like.setCount(1L);

            return this.likeRepository.save(like) != null;
        } else {
            throw new CustomException(FAILURE_POST_LIKE_MESSAGE);
        }
    }

    @Override
    public int getAllLikesForPost(String postId) throws Exception {
        Post post = this.postRepository.findById(postId).orElse(null);

        if (!postValidation.isValid(post)) {
            throw new Exception(SERVER_ERROR_MESSAGE);
        }

        return this.likeRepository.findAllByPost(post).size();
    }
}
