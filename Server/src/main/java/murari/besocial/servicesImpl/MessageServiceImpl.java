package murari.besocial.servicesImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import murari.besocial.domain.entities.Message;
import murari.besocial.domain.entities.Relationship;
import murari.besocial.domain.entities.User;
import murari.besocial.domain.models.bindingModels.MessageCreateBindingModel;
import murari.besocial.domain.models.serviceModels.MessageServiceModel;
import murari.besocial.domain.models.viewModels.MessageFriendsViewModel;
import murari.besocial.repositories.MessageRepository;
import murari.besocial.repositories.RelationshipRepository;
import murari.besocial.repositories.UserRepository;
import murari.besocial.services.MessageService;
import murari.besocial.utils.responseHandler.CustomException;
import murari.besocial.validations.serviceValidation.services.MessageValidationService;
import murari.besocial.validations.serviceValidation.services.RelationshipValidationService;
import murari.besocial.validations.serviceValidation.services.UserValidationService;

import javax.transaction.Transactional;

import static murari.besocial.utils.constants.ResponseMessageConstants.SERVER_ERROR_MESSAGE;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final RelationshipRepository relationshipRepository;
    private final UserRepository userRepository;
    private final UserValidationService userValidation;
    private final MessageValidationService messageValidation;
    private final RelationshipValidationService relationshipValidation;
    private final ModelMapper modelMapper;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, RelationshipRepository relationshipRepository, UserRepository userRepository, UserValidationService userValidation, MessageValidationService messageValidation, RelationshipValidationService relationshipValidation, ModelMapper modelMapper) {
        this.messageRepository = messageRepository;
        this.relationshipRepository = relationshipRepository;
        this.userRepository = userRepository;
        this.userValidation = userValidation;
        this.messageValidation = messageValidation;
        this.relationshipValidation = relationshipValidation;
        this.modelMapper = modelMapper;
    }

    @Override
    public MessageServiceModel createMessage(MessageCreateBindingModel messageCreateBindingModel, String loggedInUsername) throws Exception {
        if (!messageValidation.isValid(messageCreateBindingModel)) {
            throw new CustomException(SERVER_ERROR_MESSAGE);
        }

        User fromUser = userRepository
                .findByUsername(loggedInUsername)
                .filter(userValidation::isValid)
                .orElseThrow(() -> new CustomException(SERVER_ERROR_MESSAGE));

        User toUser = userRepository
                .findById(messageCreateBindingModel.getToUserId())
                .filter(userValidation::isValid)
                .orElseThrow(() -> new CustomException(SERVER_ERROR_MESSAGE));


        Relationship relationship = relationshipRepository
                .findRelationshipWithFriendWithStatus(fromUser.getId(), toUser.getId(), 1);

        if (!relationshipValidation.isValid(relationship)) {
            throw new CustomException(SERVER_ERROR_MESSAGE);
        }

        MessageServiceModel messageServiceModel = new MessageServiceModel();
        messageServiceModel.setContent(messageCreateBindingModel.getContent());
        messageServiceModel.setFromUser(fromUser);
        messageServiceModel.setToUser(toUser);
        messageServiceModel.setRelationship(relationship);
        messageServiceModel.setTime(LocalDateTime.now());

        Message message = this.modelMapper.map(messageServiceModel, Message.class);

        Message savedMessage = messageRepository.save(message);

        if(savedMessage != null){
            return  this.modelMapper.map(savedMessage, MessageServiceModel.class);
        }

        throw new CustomException(SERVER_ERROR_MESSAGE);
    }

    @Override
    public List<MessageServiceModel> getAllMessages(String loggedInUsername, String chatUserId) {
        User loggedInUser = userRepository
                .findByUsername(loggedInUsername)
                .filter(userValidation::isValid)
                .orElseThrow(() -> new CustomException(SERVER_ERROR_MESSAGE));

        User chatUser = userRepository
                .findById(chatUserId)
                .filter(userValidation::isValid)
                .orElseThrow(() -> new CustomException(SERVER_ERROR_MESSAGE));

        List<Message> allMessagesBetweenTwoUsers = this.messageRepository
                .findAllMessagesBetweenTwoUsers(loggedInUser.getId(), chatUser.getId());

        this.updateMessageStatus(loggedInUser.getId(), chatUserId);

        return allMessagesBetweenTwoUsers
                .stream().map(message -> modelMapper.map(message, MessageServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MessageFriendsViewModel> getAllFriendMessages(String loggedInUsername) {
        User loggedInUser = userRepository
                .findByUsername(loggedInUsername)
                .filter(userValidation::isValid)
                .orElseThrow(() -> new CustomException(SERVER_ERROR_MESSAGE));

        List<Message> allUnreadMessages = this.messageRepository.getAllUnreadMessages(loggedInUser.getId());

        List<MessageServiceModel> messageServiceModels = allUnreadMessages.stream()
                .map(message -> modelMapper.map(message, MessageServiceModel.class))
                .collect(Collectors.toList());

        List<MessageServiceModel> allFriendsMessages =
                messageServiceModels.stream()
                        .filter(message -> message.getRelationship().getStatus() == 1)
                        .collect(Collectors.toList());

        return mapToMessageFriendsViewModel(loggedInUser.getId(), allFriendsMessages);
    }

    private List<MessageFriendsViewModel> mapToMessageFriendsViewModel(String loggedInUserId, List<MessageServiceModel> allUnreadMessages) {
        List<Object[]> countOfUnreadMessagesByFromUser = this.messageRepository.getCountOfUnreadMessagesByFromUser(loggedInUserId);

        return allUnreadMessages.stream()
                .map(messageServiceModel -> {
                    MessageFriendsViewModel unreadViewModel = modelMapper.map(messageServiceModel, MessageFriendsViewModel.class);
                    Object[] objects = countOfUnreadMessagesByFromUser.stream()
                            .filter(element -> element[0].equals(unreadViewModel.getFromUserId()))
                            .findFirst().orElse(null);

                    if(objects != null){
                        unreadViewModel.setCount(Integer.valueOf(objects[1].toString()));
                    }else{
                        unreadViewModel.setCount(0);
                    }

                    return unreadViewModel;
                })
                .collect(Collectors.toList());
    }

    private void updateMessageStatus(String loggedInUserId, String chatUserId) {
        this.messageRepository.updateStatusFromReadMessages(loggedInUserId, chatUserId);
    }
}
