package murari.besocial.validations.serviceValidation.servicesImpl;

import org.springframework.stereotype.Component;

import murari.besocial.domain.entities.Post;
import murari.besocial.domain.models.bindingModels.PostCreateBindingModel;
import murari.besocial.validations.serviceValidation.services.PostValidationService;

@Component
public class PostValidationServiceImpl implements PostValidationService {
    @Override
    public boolean isValid(Post post) {
        return post != null;
    }

    @Override
    public boolean isValid(PostCreateBindingModel postCreateBindingModel) {
        return postCreateBindingModel != null;
    }
}
