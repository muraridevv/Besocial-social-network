package murari.besocial.validations.serviceValidation.servicesImpl;

import murari.besocial.domain.entities.Picture;
import murari.besocial.domain.entities.User;
import murari.besocial.testUtils.PictureUtils;
import murari.besocial.testUtils.UsersUtils;
import murari.besocial.validations.serviceValidation.services.PictureValidationService;
import murari.besocial.validations.serviceValidation.servicesImpl.PictureValidationServiceImpl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PictureValidationServiceTests {
    private PictureValidationService pictureValidationService;

    @Before
    public void setupTest() {
        pictureValidationService = new PictureValidationServiceImpl();
    }

    @Test
    public void isValid_whenValid_true() {
        User user = UsersUtils.createUser();
        Picture picture = PictureUtils.createPicture(user);

        boolean result = pictureValidationService.isValid(picture);
        assertTrue(result);
    }

    @Test
    public void isValid_whenNull_false() {
        Picture picture = null;
        boolean result = pictureValidationService.isValid(picture);
        assertFalse(result);
    }
}
