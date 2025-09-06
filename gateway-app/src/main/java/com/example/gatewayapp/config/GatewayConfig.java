package com.example.gatewayapp.config;

import com.example.gatewayapp.security.JwtAuthenticationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    private final JwtAuthenticationFilter jwtFilter;

    public GatewayConfig(JwtAuthenticationFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder, JwtAuthenticationFilter jwtFilter) {
        return builder.routes()
                .route("order-service", r -> r
                        .path("/order/**")
                        .filters(f -> f.filter(jwtFilter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://order-service")
                )
                .route("payment-service", r -> r
                        .path("/payment/**")
                        .filters(f -> f.filter(jwtFilter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("lb://payment-service")
                )
                .build();
    }
}
