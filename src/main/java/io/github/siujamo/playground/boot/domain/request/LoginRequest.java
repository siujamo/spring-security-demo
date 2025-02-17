package io.github.siujamo.playground.boot.domain.request;

public record LoginRequest(
        String username,
        String password
) {
}
