package com.educational.material.swagger2;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/* Order no 2
 * Defining Docket bean, its select() method returns an instance of ApiSelectBuilder, which provides a way to control the end points exposed by swagger.
 * For selecting RequestHandlers with the help of RequestHandlerSelectors and PathSelectors. Using any() for both will make documentation for our entire API available through Swagger.
*/
//@Configuration
//@EnableSwagger2
public class SpringFoxConfig {//extends WebMvcConfigurerAdapter{
	
	public static final String AUTHORIZATION_HEADER="Authorization";
	
	private ApiKey apiKey() {
		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
	/*
	 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * registry.addResourceHandler("swagger-ui.html")
	 * .addResourceLocations("classpath:/META-INF/resources/");
	 * 
	 * registry.addResourceHandler("/webjars/**")
	 * .addResourceLocations("classpath:/META-INF/resources/webjars/"); }
	 */
}
