package com.github.jaksa97.LeafSaver;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LeafSaverApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeafSaverApplication.class, args);
    }

    @Bean
    public OpenAPI leafSaverOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Leaf Saver API")
                        .description("REST API for Leaf Saver application")
                        .version("v0.0.1")
                );
    }
}
