package org.acme.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.acme.controller"))
                .paths(PathSelectors.any()) //.ant("/api/*")
                .build()
                .apiInfo(apiInfo());
//                .useDefaultResponseMessages(false)
//                .globalResponseMessage(RequestMethod.GET, responseMessageForGET());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Exemplo de swagger")
                .description("Exemplo de documentação para swagger")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("Matheus", "matheus.svb", "email"))
                .build();
    }

//    private List<ResponseMessage> responseMessageForGET(){
//        return new ArrayList<ResponseMessage>() {{
//            add(new ResponseMessageBuilder()
//                    .code(500)
//                    .message("500 message")
//                    .responseModel(new ModelRef("Error"))
//                    .build());
//            add(new ResponseMessageBuilder()
//                    .code(403)
//                    .message("Forbidden!")
//                    .build());
//        }};
//    }
}
