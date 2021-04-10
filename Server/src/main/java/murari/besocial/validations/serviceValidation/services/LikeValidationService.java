package murari.besocial.validations.serviceValidation.services;

import murari.besocial.domain.entities.Like;

public interface LikeValidationService {
    boolean isValid(Like like);
}
