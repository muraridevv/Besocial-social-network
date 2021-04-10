package murari.besocial.validations.serviceValidation.servicesImpl;

import murari.besocial.domain.entities.Like;
import murari.besocial.domain.entities.Post;
import murari.besocial.domain.entities.User;
import murari.besocial.testUtils.LikesUtils;
import murari.besocial.testUtils.PostsUtils;
import murari.besocial.testUtils.UsersUtils;
import murari.besocial.validations.serviceValidation.services.LikeValidationService;
import murari.besocial.validations.serviceValidation.servicesImpl.LikeValidationServiceImpl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LikeValidationServiceTests {
    private LikeValidationService likeValidationService;

    @Before
    public void setupTest() {
        likeValidationService = new LikeValidationServiceImpl();
    }

    @Test
    public void isValid_whenValid_true() {
        User user = UsersUtils.createUser();
        Post post = PostsUtils.createPost(user, user);
        Like like = LikesUtils.createLike(user, post);

        boolean result = likeValidationService.isValid(like);
        assertTrue(result);
    }

    @Test
    public void isValid_whenNull_false() {
        Like like = null;
        boolean result = likeValidationService.isValid(like);
        assertFalse(result);
    }
}
