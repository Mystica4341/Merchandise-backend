package com.mirera.merchandise.infrastructure.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
  info = @Info(
    title = "Merchandise API",
    version = "v1",
    description = "API documentation for Merchandise backend",
    contact = @Contact(name = "Mirera Team")
  )
)
public class OpenApiConfig {
}
