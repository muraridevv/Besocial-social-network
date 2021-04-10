package murari.besocial.validations.serviceValidation.servicesImpl;

import org.springframework.stereotype.Component;

import murari.besocial.domain.entities.Picture;
import murari.besocial.validations.serviceValidation.services.PictureValidationService;

@Component
public class PictureValidationServiceImpl implements PictureValidationService {
    @Override
    public boolean isValid(Picture picture) {
        return picture != null;
    }
}
