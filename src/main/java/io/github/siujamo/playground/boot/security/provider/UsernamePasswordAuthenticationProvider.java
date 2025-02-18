package io.github.siujamo.playground.boot.security.provider;

import io.github.siujamo.playground.boot.exception.BizException;
import io.github.siujamo.playground.boot.security.token.UsernamePasswordToken;
import io.github.siujamo.playground.boot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    private static final Logger log = LoggerFactory.getLogger(UsernamePasswordAuthenticationProvider.class);

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsernamePasswordAuthenticationProvider(UserService userService,
                                                  PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordToken.class);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication instanceof UsernamePasswordToken usernamePasswordToken) {
            var userDetails = userService.loadUserByUsername(usernamePasswordToken.getUsername());
            if (passwordEncoder.matches(usernamePasswordToken.getPassword(), userDetails.getPassword())) {
                usernamePasswordToken.setAuthenticated(true);
                usernamePasswordToken.setDetails(userDetails);
                usernamePasswordToken.eraseCredentials();
                return usernamePasswordToken;
            }

            throw new BizException(HttpStatus.UNAUTHORIZED, "用户名与密码不匹配。");
        }

        throw new BizException(HttpStatus.INTERNAL_SERVER_ERROR, "服务器错误。");
    }
}
