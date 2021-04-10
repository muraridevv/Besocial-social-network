package murari.besocial.services;

import java.util.concurrent.CompletableFuture;

import murari.besocial.domain.models.bindingModels.CommentCreateBindingModel;

public interface CommentService {
    boolean createComment(CommentCreateBindingModel commentCreateBindingModel) throws Exception;

    CompletableFuture<Boolean> deleteComment(String loggedInUserId, String commentToRemoveId) throws Exception;
}
