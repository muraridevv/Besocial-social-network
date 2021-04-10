package murari.besocial.validations.serviceValidation.services;

import murari.besocial.domain.models.bindingModels.MessageCreateBindingModel;

public interface MessageValidationService {
    boolean isValid(MessageCreateBindingModel messageCreateBindingModel);
}
