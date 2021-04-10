package murari.besocial.validations.serviceValidation.services;

import org.springframework.security.core.userdetails.UserDetails;

import murari.besocial.domain.entities.User;
import murari.besocial.domain.models.bindingModels.UserRegisterBindingModel;
import murari.besocial.domain.models.bindingModels.UserUpdateBindingModel;
import murari.besocial.domain.models.serviceModels.UserServiceModel;

public interface UserValidationService {
    boolean isValid(User user);

    boolean isValid(UserServiceModel userServiceModel);

    boolean isValid(UserRegisterBindingModel userRegisterBindingModel);

    boolean isValid(String firstParam, String secondParam);

    boolean isValid(UserUpdateBindingModel userUpdateBindingModel);

    boolean isValid(UserDetails userData);
}
