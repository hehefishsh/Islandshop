package com.example.Islandshop.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI defineOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("IslandProduct Api")
                        .version("1.0")
                        .description("3C產品 API")
                        .contact(new Contact()
                                .name("Seren")
                                .email("SerenChen@seren.com"))
                );

    }
}
