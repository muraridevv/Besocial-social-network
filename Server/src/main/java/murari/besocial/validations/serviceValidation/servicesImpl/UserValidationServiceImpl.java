package murari.besocial.validations.serviceValidation.servicesImpl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import murari.besocial.domain.entities.User;
import murari.besocial.domain.models.bindingModels.UserRegisterBindingModel;
import murari.besocial.domain.models.bindingModels.UserUpdateBindingModel;
import murari.besocial.domain.models.serviceModels.UserServiceModel;
import murari.besocial.validations.serviceValidation.services.UserValidationService;

@Component
public class UserValidationServiceImpl implements UserValidationService {

    @Override
    public boolean isValid(User user) {
        return user != null;
    }

    @Override
    public boolean isValid(UserServiceModel userServiceModel) {
        return userServiceModel != null;
    }

    @Override
    public boolean isValid(UserRegisterBindingModel userRegisterBindingModel) {
        return userRegisterBindingModel != null && isValid(userRegisterBindingModel.getPassword(), userRegisterBindingModel.getConfirmPassword());
    }

    @Override
    public boolean isValid(String firstParam, String secondParam) {
        return firstParam.equals(secondParam);
    }

    @Override
    public boolean isValid(UserUpdateBindingModel userUpdateBindingModel) {
        return userUpdateBindingModel != null;
    }

    @Override
    public boolean isValid(UserDetails userData) {
        return userData != null;
    }

}
