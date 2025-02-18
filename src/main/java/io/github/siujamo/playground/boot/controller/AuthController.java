package io.github.siujamo.playground.boot.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.onixbyte.simplejwt.TokenResolver;
import io.github.siujamo.playground.boot.domain.request.LoginRequest;
import io.github.siujamo.playground.boot.entity.User;
import io.github.siujamo.playground.boot.exception.BizException;
import io.github.siujamo.playground.boot.security.token.UsernamePasswordToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenResolver<DecodedJWT> tokenResolver;

    public AuthController(AuthenticationManager authenticationManager, TokenResolver<DecodedJWT> tokenResolver) {
        this.authenticationManager = authenticationManager;
        this.tokenResolver = tokenResolver;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest request) {
        var _auth = authenticationManager.authenticate(UsernamePasswordToken.unauthenticated(request.username(), request.password()));
        if (_auth instanceof UsernamePasswordToken auth) {
            var user = auth.getDetails();
            var token = tokenResolver.createToken(Duration.ofDays(1), auth.getName(), "USER");
            return ResponseEntity.status(HttpStatus.OK)
                    .header("Authorization", token)
                    .body(user);
        }
        throw new BizException(HttpStatus.UNAUTHORIZED, "无法完成身份验证，请稍后再试");
    }

}
