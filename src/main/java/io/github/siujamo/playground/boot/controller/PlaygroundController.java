package io.github.siujamo.playground.boot.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playground")
public class PlaygroundController {

    private static final Logger log = LoggerFactory.getLogger(PlaygroundController.class);

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        log.info("Hello from {}", request.getRemoteAddr());
        return "Hello World";
    }

}
