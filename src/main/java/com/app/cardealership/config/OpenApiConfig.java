package com.app.cardealership.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

//Clase de configuracion de Swagger OpenAPI
@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Car-dealership",
                version = "1.0.0",
                description = "Car dealership application"

        )
)
public class OpenApiConfig {
}