package com.josmejia2401.nuevospa.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.*;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Tareas - NUEVO SPA")
                        .version("1.0")
                        .description("API RESTful para gestionar tareas con autenticación JWT"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("tareas")
                .pathsToMatch("/**")
                .build();
    }
}

