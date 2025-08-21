package com.educational.material;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages={"com.*"})
@EnableEurekaClient
//@EnableSwagger2
@ComponentScan("com.educational.material")
public class EducationalMaterialsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducationalMaterialsServiceApplication.class, args);
	}

}

