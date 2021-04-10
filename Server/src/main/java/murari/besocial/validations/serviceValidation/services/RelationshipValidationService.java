package murari.besocial.validations.serviceValidation.services;

import murari.besocial.domain.entities.Relationship;

public interface RelationshipValidationService {
    boolean isValid(Relationship relationship);
}
