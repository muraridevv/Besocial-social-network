package murari.besocial.validations.serviceValidation.servicesImpl;

import org.springframework.stereotype.Component;

import murari.besocial.domain.entities.UserRole;
import murari.besocial.validations.serviceValidation.services.RoleValidationService;

@Component
public class RoleValidationServiceImpl implements RoleValidationService {
    @Override
    public boolean isValid(UserRole role) {
        return role != null;
    }
}
