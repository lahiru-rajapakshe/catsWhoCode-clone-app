package online.lahiru.sprinngbotrestapi.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "CatsWhoCode Clone App Spring Boot rest APIs",
                "Spring Boot Rest Apis Documentattion",
                "1",
                "Terms of service",

                new Contact("Lahiru Rajapakshe","www.lahirurj.online",
                        "lahirurajapakshe.stack@gmail.com"),
                "License of API",
                "API License URL",
                Collections.emptyList()
        );
    }

}
