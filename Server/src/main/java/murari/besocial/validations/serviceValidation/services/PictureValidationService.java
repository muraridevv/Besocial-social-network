package murari.besocial.validations.serviceValidation.services;

import murari.besocial.domain.entities.Picture;

public interface PictureValidationService {
    boolean isValid(Picture picture);
}
