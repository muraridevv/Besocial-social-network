package murari.besocial.validations.serviceValidation.servicesImpl;

import org.springframework.stereotype.Component;

import murari.besocial.domain.models.serviceModels.LoggerServiceModel;
import murari.besocial.validations.serviceValidation.services.LoggerValidationService;

@Component
public class LoggerValidationServiceImpl implements LoggerValidationService {
    @Override
    public boolean isValid(LoggerServiceModel loggerServiceModel) {
        return loggerServiceModel != null;
    }

    @Override
    public boolean isValid(String method, String principal, String tableName, String action) {
        return method != null && principal != null && tableName != null && action != null;
    }

    @Override
    public boolean isValid(String username) {
        return username != null;
    }
}
