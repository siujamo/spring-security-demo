package io.github.siujamo.playground.boot.exception;

import io.github.siujamo.playground.boot.domain.response.BizExceptionResponse;
import org.springframework.http.HttpStatus;

public class BizException extends RuntimeException {

    private final HttpStatus status;

    public BizException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public BizExceptionResponse composeResponse() {
        return BizExceptionResponse.builder()
                .message(getMessage())
                .build();
    }
}
