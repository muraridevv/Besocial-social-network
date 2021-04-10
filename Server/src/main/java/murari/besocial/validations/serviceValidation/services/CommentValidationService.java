package murari.besocial.validations.serviceValidation.services;

import murari.besocial.domain.entities.Comment;
import murari.besocial.domain.models.bindingModels.CommentCreateBindingModel;

public interface CommentValidationService {
    boolean isValid(Comment comment);

    boolean isValid(CommentCreateBindingModel commentCreateBindingModel);
}
