package murari.besocial.validations.serviceValidation.servicesImpl;

import org.springframework.stereotype.Component;

import murari.besocial.domain.entities.Comment;
import murari.besocial.domain.models.bindingModels.CommentCreateBindingModel;
import murari.besocial.validations.serviceValidation.services.CommentValidationService;

@Component
public class CommentValidationServiceImpl implements CommentValidationService {
    @Override
    public boolean isValid(Comment comment) {
        return comment != null;
    }

    @Override
    public boolean isValid(CommentCreateBindingModel commentCreateBindingModel) {
        return commentCreateBindingModel != null;
    }
}
