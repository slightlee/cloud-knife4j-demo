package com.demain.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 接口文档配置
 *
 * @author demain_lee
 * @since 2023/8/18
 */
@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI openApi() {
		//	@formatter:off
        return new OpenAPI()
                .info(apiInfo())
                ;
        // @formatter:on
	}

	public Info apiInfo() {
		//	@formatter:off
        return new Info()
                .title("User API")
                .description("User API Description")
                .contact(new Contact()
                        .name("demain_lee")
                        .email("lmm_work@163.com")
                        .url("https://xxxxxxxx.com"))
                .license(new License()
                        .name("Apache 2.0")
                        .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                .version("0.0.1")
		;
		// @formatter:on
	}

}
