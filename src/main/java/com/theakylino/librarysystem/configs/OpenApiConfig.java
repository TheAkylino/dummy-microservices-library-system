package com.theakylino.librarysystem.configs;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Sistema de Biblioteca",
        version = "1.0.0",
        description = "Recto Técnico Sistema de Biblioteca Arquitectura de Microservicios"
    )
)
public class OpenApiConfig {}
