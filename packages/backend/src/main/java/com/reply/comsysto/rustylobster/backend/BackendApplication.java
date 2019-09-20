package com.reply.comsysto.rustylobster.backend;

import com.reply.comsysto.rustylobster.backend.config.SwaggerConfig;
import com.reply.comsysto.rustylobster.backend.controllers.HealthController;
import io.swagger.models.auth.In;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BackendApplication {
  public static void main(final String[] args) {
    SpringApplication.run(BackendApplication.class, args);
  }

  @Bean
  public Docket swaggerApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage(HealthController.class.getPackageName()))
        .paths(PathSelectors.any())
        .build()
        .useDefaultResponseMessages(false)
        .directModelSubstitute(Object.class, Void.class)
        .tags(
            new Tag("Burgers", "List and create burgers configurations"),
            new Tag("Ingredients", "List all ingredients used for the creation of burgers"),
            new Tag("Health", "Operations to monitor the health of the server"),
            new Tag("Authentication", "Provides operations to handle token-based authentication"))
        .securitySchemes(
            List.of(
                new ApiKey(
                    SwaggerConfig.JWT_AUTH_TOKEN, HttpHeaders.AUTHORIZATION, In.HEADER.name())))
        .apiInfo(
            new ApiInfoBuilder()
                .title("Rusty Lobster REST API")
                .description("This is the Swagger documentation for the Rusty Lobster REST API")
                .version("1.0.0-SNAPSHOT")
                .license("MIT")
                .contact(new Contact("Christian Ivicevic", null, "c.ivicevic@reply.de"))
                .build());
  }
}
