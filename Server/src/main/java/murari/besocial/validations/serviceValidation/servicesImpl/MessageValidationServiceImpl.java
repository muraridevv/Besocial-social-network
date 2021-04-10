package murari.besocial.validations.serviceValidation.servicesImpl;

import org.springframework.stereotype.Component;

import murari.besocial.domain.models.bindingModels.MessageCreateBindingModel;
import murari.besocial.validations.serviceValidation.services.MessageValidationService;

@Component
public class MessageValidationServiceImpl implements MessageValidationService {

    @Override
    public boolean isValid(MessageCreateBindingModel messageCreateBindingModel) {
        return messageCreateBindingModel != null;
    }
}
