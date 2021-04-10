package murari.besocial.validations.serviceValidation.servicesImpl;

import murari.besocial.domain.models.bindingModels.MessageCreateBindingModel;
import murari.besocial.testUtils.MessagesUtils;
import murari.besocial.validations.serviceValidation.services.MessageValidationService;
import murari.besocial.validations.serviceValidation.servicesImpl.MessageValidationServiceImpl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MessageValidationServiceTests {
    private MessageValidationService messageValidationService;

    @Before
    public void setupTest(){
        messageValidationService = new MessageValidationServiceImpl();
    }

    @Test
    public void isValidWithMessageCreateBindingModel_whenValid_true(){
        MessageCreateBindingModel messageCreateBindingModel = MessagesUtils.getMessageCreateBindingModel();
        boolean result = messageValidationService.isValid(messageCreateBindingModel);
        assertTrue(result);
    }

    @Test
    public void isValidWithMessageCreateBindingModel_whenNull_false(){
        MessageCreateBindingModel messageCreateBindingModel =  null;
        boolean result = messageValidationService.isValid(messageCreateBindingModel);
        assertFalse(result);
    }

}
