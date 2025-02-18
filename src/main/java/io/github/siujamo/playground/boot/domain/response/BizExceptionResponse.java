package io.github.siujamo.playground.boot.domain.response;

import java.time.LocalDateTime;
import java.util.Optional;

public record BizExceptionResponse(
        String message,
        LocalDateTime timestamp
) {

    public static BizExceptionResponseBuilder builder() {
        return new BizExceptionResponseBuilder();
    }

    public static class BizExceptionResponseBuilder {
        private String message;
        private LocalDateTime timestamp;

        private BizExceptionResponseBuilder() {
        }

        public BizExceptionResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public BizExceptionResponseBuilder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public BizExceptionResponse build() {
            var _timestamp = Optional.ofNullable(timestamp)
                    .orElseGet(LocalDateTime::now);
            return new BizExceptionResponse(message, _timestamp);
        }
    }

}
