package com.java.back.end.getway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GetwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetwayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user_route", r -> r.path("/user/**")
                        .uri("http://localhost:8080"))
                .route("product_route", r -> r.path("/product/**")
                        .uri("http://localhost:8081"))
                .route("shopping_route", r -> r.path("/shopping/** ")
                        .uri("http://localhost:8082"))
                .build();
    }

}
