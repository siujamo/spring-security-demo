package io.github.siujamo.playground.boot.security.token;

import io.github.siujamo.playground.boot.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UsernamePasswordToken implements Authentication, CredentialsContainer {

    private boolean authenticated;

    private User details;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return details.getAuthorities();
    }

    @Override
    public String getCredentials() {
        return details.getPassword();
    }

    @Override
    public User getDetails() {
        return details;
    }

    @Override
    public String getPrincipal() {
        return details.getUsername();
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
        this.authenticated = authenticated;
    }

    @Override
    public String getName() {
        return details.getUsername();
    }

    public void setDetails(User details) {
        this.details = details;
    }

    public String getUsername() {
        return details.getUsername();
    }

    public void setUsername(String username) {
        this.details.setUsername(username);
    }

    public String getPassword() {
        return details.getPassword();
    }

    public void setPassword(String password) {
        this.details.setPassword(password);
    }

    public Integer getId() {
        return details.getId();
    }

    public void setId(Integer id) {
        details.setId(id);
    }

    public static UsernamePasswordToken authenticated(Integer id, String username) {
        var user = new User();
        user.setId(id);
        user.setUsername(username);

        var token = new UsernamePasswordToken();
        token.details = user;
        token.setAuthenticated(true);

        return token;
    }

    public static UsernamePasswordToken unauthenticated(String username, String password) {
        var user = new User();
        user.setUsername(username);
        user.setPassword(password);

        var token = new UsernamePasswordToken();
        token.details = user;
        token.setAuthenticated(false);

        return token;
    }

    @Override
    public void eraseCredentials() {
        details.setPassword("");
    }
}
