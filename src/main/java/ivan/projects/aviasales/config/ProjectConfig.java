package ivan.projects.aviasales.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class ProjectConfig {

    private static final String TITLE = "Документация к тестовому заданию Aviasales";
    private static final String VERSION = "1.0";
    private static final String COPYRIGHT = "(C) Copyright 2020";
    private static final String DESCRIPTION = "Здесь содержится список endpoint-ов, которые поддерживает тестовое приложение";

    @Bean
    Docket Docs(ApiInfo apiInfo){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ivan.projects"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo);
    }
    @Bean
    public ApiInfo apiInfo() {
        final ApiInfoBuilder builder = new ApiInfoBuilder();
        builder.title(TITLE).version(VERSION).license(COPYRIGHT)
                .description(DESCRIPTION);
        return builder.build();
    }
}
