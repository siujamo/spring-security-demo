package io.github.siujamo.playground.boot.controller;

import io.github.siujamo.playground.boot.exception.BizException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playground")
public class PlaygroundController {

    @GetMapping("/biz-exception")
    public String bizException() {
        throw new BizException(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "该功能暂未开放");
    }

}
