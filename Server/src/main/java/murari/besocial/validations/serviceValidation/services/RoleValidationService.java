package murari.besocial.validations.serviceValidation.services;

import murari.besocial.domain.entities.UserRole;

public interface RoleValidationService {
    boolean isValid(UserRole role);
}
