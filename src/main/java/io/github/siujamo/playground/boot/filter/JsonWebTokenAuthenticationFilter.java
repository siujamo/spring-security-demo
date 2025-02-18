package io.github.siujamo.playground.boot.filter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onixbyte.simplejwt.TokenResolver;
import io.github.siujamo.playground.boot.domain.response.BizExceptionResponse;
import io.github.siujamo.playground.boot.exception.BizException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@Component
public class JsonWebTokenAuthenticationFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;
    private final TokenResolver<DecodedJWT> tokenResolver;

    public JsonWebTokenAuthenticationFilter(ObjectMapper objectMapper, TokenResolver<DecodedJWT> tokenResolver) {
        this.objectMapper = objectMapper;
        this.tokenResolver = tokenResolver;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var jsonWebToken = Optional.of(request)
                .map((_request) -> _request.getHeader("Authorization"))
                .or(() -> Optional.ofNullable(request.getHeader("authorization")))
                .orElse(null);

        if (Objects.isNull(jsonWebToken)) {
            filterChain.doFilter(request, response);
            return;
        }

        // tokenResolver.resolve(jsonWebToken);
        // if (shouldThrowBizException) {
        //     // 手动编写返回信息
        //     response.setStatus(HttpStatus.UNAUTHORIZED.value());
        //     response.setContentType("application/json; charset=UTF-8");
        //     response.setCharacterEncoding("UTF-8");
        //     response.getWriter().write(objectMapper.writeValueAsString(BizExceptionResponse.builder()
        //             .message("您还没有登录，请登录后再试")
        //             .build()));
        //     response.getWriter().flush();
        //     return;
        // }
        filterChain.doFilter(request, response);
    }

}
