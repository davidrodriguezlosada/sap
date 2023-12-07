package com.davidrl.sap.service.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for swagger to expose APIs info
 */
@Configuration
public class SpringDocConfig {
  @Bean
  public OpenAPI springShopOpenAPI() {
    return new OpenAPI()
            .info(new Info().title("SAP API")
                    .description("sap")
                    .version("v0.0.1")
                    .license(new License().name("MIT").url("https://mit-license.org/")));
  }
}