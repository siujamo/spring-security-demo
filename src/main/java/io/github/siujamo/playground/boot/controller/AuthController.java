package io.github.siujamo.playground.boot.controller;

import io.github.siujamo.playground.boot.domain.request.LoginRequest;
import io.github.siujamo.playground.boot.security.token.UsernamePasswordToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        var _auth = authenticationManager.authenticate(UsernamePasswordToken.unauthenticated(request.username(), request.password()));
        return _auth.getName();
    }

}
