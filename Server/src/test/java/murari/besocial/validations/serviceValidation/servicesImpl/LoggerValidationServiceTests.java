package murari.besocial.validations.serviceValidation.servicesImpl;

import murari.besocial.domain.models.serviceModels.LoggerServiceModel;
import murari.besocial.testUtils.LoggerUtils;
import murari.besocial.validations.serviceValidation.services.LoggerValidationService;
import murari.besocial.validations.serviceValidation.servicesImpl.LoggerValidationServiceImpl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoggerValidationServiceTests {
    private LoggerValidationService loggerValidation;

    @Before
    public void setupTest() {
        loggerValidation = new LoggerValidationServiceImpl();
    }

    @Test
    public void isValidWithLoggerServiceModel_whenValid_true() {
        LoggerServiceModel loggerServiceModel = LoggerUtils.getLoggerServiceModels(1).get(0);

        boolean result = loggerValidation.isValid(loggerServiceModel);
        assertTrue(result);
    }

    @Test
    public void isValidWithLoggerServiceModel_whenNull_false() {
        LoggerServiceModel loggerServiceModel =  null;
        boolean result = loggerValidation.isValid(loggerServiceModel);
        assertFalse(result);
    }

    @Test
    public void isValidWith4Strings_whenValid_true() {
        String method = "POST";
        String principal = "principal";
        String tableName = "users";
        String action = "add";
        boolean result = loggerValidation.isValid(method, principal, tableName, action);
        assertTrue(result);
    }

    @Test
    public void isValidWith4Strings_whenOneOfTheStringIsNull_false() {
        String method = "POST";
        String principal = "principal";
        String tableName = "users";
        String action = null;
        boolean result = loggerValidation.isValid(method, principal, tableName, action);
        assertFalse(result);
    }

    @Test
    public void isValidWith4Strings_whenAllAreNull_false() {
        String method = null;
        String principal = null;
        String tableName = null;
        String action = null;
        boolean result = loggerValidation.isValid(method, principal, tableName, action);
        assertFalse(result);
    }

    @Test
    public void isValidWithUsername_whenValid_true() {
        String username = "username";
        boolean result = loggerValidation.isValid(username);
        assertTrue(result);
    }

    @Test
    public void isValidWithUsername_whenIsNull_false() {
        String username = null;
        boolean result = loggerValidation.isValid(username);
        assertFalse(result);
    }
}
