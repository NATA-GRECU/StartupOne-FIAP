package br.com.connectFood.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Configuration
@EnableWebMvc
@EnableSwagger2WebMvc
@OpenAPIDefinition(
        info = @Info(
                title = "Título da API",
                description = "Descrição da API",
                version = "1.0.0"
        ),
        servers = @io.swagger.v3.oas.annotations.servers.Server(url = "http://localhost:8080/api")
)
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.connectFood.controller"))
                .paths(PathSelectors.any())
                .build()
                .servers(server())
                .apiInfo(apiInfo());
    }

    private Server server() {
        Server server = new Server("Descrição da API","http://localhost:8080/api", "",Collections.emptyList(), new ArrayList<>());
        return server;
    }

    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder()
                .title("ConnectFood")
                .description("Documentação de APIs da aplicação Connect Food.")
                .version("1.0")
                .contact(contact())
                .build();
    }

    private Contact contact()
    {
        return new Contact("Natã Grecu",
                "https://github.com/NATA-GRECU",
                "Desenvolvedor Java Pleno Full stack");
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }
}