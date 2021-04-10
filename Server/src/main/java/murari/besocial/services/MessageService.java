package murari.besocial.services;

import java.util.List;

import murari.besocial.domain.models.bindingModels.MessageCreateBindingModel;
import murari.besocial.domain.models.serviceModels.MessageServiceModel;
import murari.besocial.domain.models.viewModels.MessageFriendsViewModel;

public interface MessageService {

    MessageServiceModel createMessage(MessageCreateBindingModel messageCreateBindingModel, String loggedInUsername) throws Exception;

    List<MessageServiceModel> getAllMessages(String loggedInUsername, String chatUserId);

    List<MessageFriendsViewModel> getAllFriendMessages(String loggedInUsername);
}
