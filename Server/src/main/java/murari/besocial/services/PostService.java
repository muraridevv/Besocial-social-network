package murari.besocial.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import murari.besocial.domain.models.bindingModels.PostCreateBindingModel;
import murari.besocial.domain.models.serviceModels.PostServiceModel;

public interface PostService {
    boolean createPost(PostCreateBindingModel postCreateBindingModel) throws Exception;

    List<PostServiceModel> getAllPosts(String timelineUserId);

    CompletableFuture<Boolean> deletePost(String loggedInUserId, String postToRemoveId) throws Exception;
}
