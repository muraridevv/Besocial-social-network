package murari.besocial.validations.serviceValidation.servicesImpl;

import murari.besocial.domain.entities.UserRole;
import murari.besocial.testUtils.RolesUtils;
import murari.besocial.validations.serviceValidation.services.RoleValidationService;
import murari.besocial.validations.serviceValidation.servicesImpl.RoleValidationServiceImpl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RoleValidationServiceTests {
    private RoleValidationService roleValidationService;

    @Before
    public void setupTest(){
        roleValidationService = new RoleValidationServiceImpl();
    }

    @Test
    public void isValid_whenValid_true(){
        UserRole userRole = RolesUtils.createUserRole();
        boolean result = roleValidationService.isValid(userRole);
        assertTrue(result);
    }

    @Test
    public void isValid_whenNull_false(){
        UserRole userRole =  null;
        boolean result = roleValidationService.isValid(userRole);
        assertFalse(result);
    }
}
