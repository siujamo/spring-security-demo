package io.github.siujamo.playground.boot.config;

import io.github.siujamo.playground.boot.property.CorsProperty;
import io.github.siujamo.playground.boot.utils.ListUtil;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Optional;

@Configuration
@EnableConfigurationProperties(CorsProperty.class)
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource(CorsProperty corsProperty) {
        var configuration = new CorsConfiguration();

        Optional.ofNullable(corsProperty)
                .map(CorsProperty::getAllowedOrigins)
                .map(ListUtil::toList)
                .ifPresent(configuration::setAllowedOrigins);

        Optional.ofNullable(corsProperty)
                .map(CorsProperty::getAllowedMethods)
                .map((allowedMethods) -> ListUtil.toList(allowedMethods, RequestMethod::name))
                .ifPresent(configuration::setAllowedMethods);

        Optional.ofNullable(corsProperty)
                .map(CorsProperty::getAllowedHeaders)
                .map(ListUtil::toList)
                .ifPresent(configuration::setAllowedHeaders);

        Optional.ofNullable(corsProperty)
                .map(CorsProperty::getAllowCredentials)
                .ifPresent(configuration::setAllowCredentials);

        Optional.ofNullable(corsProperty)
                .map(CorsProperty::getMaxAge)
                .ifPresent(configuration::setMaxAge);

        Optional.ofNullable(corsProperty)
                .map(CorsProperty::getExposedHeaders)
                .map(ListUtil::toList)
                .ifPresent(configuration::setExposedHeaders);

        var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
