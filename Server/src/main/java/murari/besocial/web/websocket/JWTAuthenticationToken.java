package murari.besocial.web.websocket;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import murari.besocial.domain.entities.User;

import java.util.Collection;

public class JWTAuthenticationToken extends AbstractAuthenticationToken implements Authentication {
    private String token;
    private User principal;

    public JWTAuthenticationToken(Collection<? extends GrantedAuthority> authorities, String token, User principal) {
        super(authorities);
        this.token =  token;
        this.principal = principal;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }
}
