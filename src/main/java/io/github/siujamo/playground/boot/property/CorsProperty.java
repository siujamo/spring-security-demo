package io.github.siujamo.playground.boot.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMethod;

@ConfigurationProperties(prefix = "app.cors")
public class CorsProperty {

    private Boolean allowCredentials;

    private String[] allowedOrigins;

    private String[] allowedHeaders;

    private RequestMethod[] allowedMethods;

    private String[] exposedHeaders;

    private Long maxAge;

    public CorsProperty() {
    }

    public CorsProperty(Boolean allowCredentials, String[] allowedOrigins, String[] allowedHeaders, RequestMethod[] allowedMethods, String[] exposedHeaders, Long maxAge) {
        this.allowCredentials = allowCredentials;
        this.allowedOrigins = allowedOrigins;
        this.allowedHeaders = allowedHeaders;
        this.allowedMethods = allowedMethods;
        this.exposedHeaders = exposedHeaders;
        this.maxAge = maxAge;
    }

    public Boolean getAllowCredentials() {
        return allowCredentials;
    }

    public void setAllowCredentials(Boolean allowCredentials) {
        this.allowCredentials = allowCredentials;
    }

    public String[] getAllowedOrigins() {
        return allowedOrigins;
    }

    public void setAllowedOrigins(String[] allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    public String[] getAllowedHeaders() {
        return allowedHeaders;
    }

    public void setAllowedHeaders(String[] allowedHeaders) {
        this.allowedHeaders = allowedHeaders;
    }

    public RequestMethod[] getAllowedMethods() {
        return allowedMethods;
    }

    public void setAllowedMethods(RequestMethod[] allowedMethods) {
        this.allowedMethods = allowedMethods;
    }

    public String[] getExposedHeaders() {
        return exposedHeaders;
    }

    public void setExposedHeaders(String[] exposedHeaders) {
        this.exposedHeaders = exposedHeaders;
    }

    public Long getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Long maxAge) {
        this.maxAge = maxAge;
    }

}
