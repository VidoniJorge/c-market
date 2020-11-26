package com.market.web.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun api(): Docket {
        println("SWAGGER")
        return Docket(DocumentationType.SWAGGER_2) // Indicamos el tipo de documentacion
                .select() // Indicamos que queremos que se documente
                .apis(RequestHandlerSelectors.basePackage("com.market.web.controller"))
                .build()
    }
}