package murari.besocial.validations.serviceValidation.services;

import murari.besocial.domain.entities.Post;
import murari.besocial.domain.models.bindingModels.PostCreateBindingModel;

public interface PostValidationService {
    boolean isValid(Post post);

    boolean isValid(PostCreateBindingModel postCreateBindingModel);
}
