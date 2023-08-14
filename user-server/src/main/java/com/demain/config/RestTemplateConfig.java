package com.demain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate配置
 *
 * @author demain_lee
 * @since 2023/8/14
 */
@Configuration
public class RestTemplateConfig {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
