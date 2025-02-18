package io.github.siujamo.playground.boot.controller.advice;

import io.github.siujamo.playground.boot.domain.response.BizExceptionResponse;
import io.github.siujamo.playground.boot.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    private static final Logger log = LoggerFactory.getLogger(GlobalControllerAdvice.class);

    @ExceptionHandler(BizException.class)
    public ResponseEntity<BizExceptionResponse> handleBizException(BizException e) {
        log.error("", e);
        return ResponseEntity.status(e.getStatus())
                .body(e.composeResponse());
    }

}
