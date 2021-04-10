package murari.besocial.validations.serviceValidation.servicesImpl;

import org.springframework.stereotype.Component;

import murari.besocial.domain.entities.Like;
import murari.besocial.validations.serviceValidation.services.LikeValidationService;

@Component
public class LikeValidationServiceImpl implements LikeValidationService {
    @Override
    public boolean isValid(Like like) {
        return like != null;
    }
}
