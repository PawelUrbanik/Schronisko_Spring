package com.pawel.Schronisko_Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
//@PropertySource("classpath:application.properties")
public class SchroniskoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchroniskoSpringApplication.class, args);
	}


	@Bean
	WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/css/**")
						.addResourceLocations("classpath:/css/");
				registry.addResourceHandler("/img/**")
						.addResourceLocations("classpath:/img/");
				registry.addResourceHandler("/fonts/**")
						.addResourceLocations("classpath:/fonts/");
				registry.addResourceHandler("/js/**")
						.addResourceLocations("classpath:/js/");
				registry.addResourceHandler("/templates/fragment/**")
						.addResourceLocations("classpath:/fragment/");

			}
		};
	}
}
