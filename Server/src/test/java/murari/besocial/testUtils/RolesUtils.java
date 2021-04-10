package murari.besocial.testUtils;

import murari.besocial.domain.entities.UserRole;

public class RolesUtils {
    public static UserRole createUserRole() {
        return new UserRole() {{
            setId("1");
            setAuthority("USER");
        }};
    }

    public static UserRole createAdminRole() {
        return new UserRole() {{
            setId("1");
            setAuthority("ADMIN");
        }};
    }

    public static UserRole createRootRole() {
        return new UserRole() {{
            setId("1");
            setAuthority("ROOT");
        }};
    }
}

