package com.vacilo.forum.config

import org.jetbrains.annotations.Contract
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class ApplicationConfig {

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vacilo.forum.controller"))
                .paths(PathSelectors.any())
                .build()
    }

    private fun getApiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("Vacilo Forum API")
                .description("API's kotlin")
                .version("1.0.0")
                .build()

    }

}