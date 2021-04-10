package murari.besocial.validations.serviceValidation.servicesImpl;

import org.springframework.stereotype.Component;

import murari.besocial.domain.entities.Relationship;
import murari.besocial.validations.serviceValidation.services.RelationshipValidationService;

@Component
public class RelationshipValidationServiceImpl implements RelationshipValidationService {
    @Override
    public boolean isValid(Relationship relationship) {
        return relationship != null;
    }
}
