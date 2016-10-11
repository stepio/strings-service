package org.stepio.strings.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Spring Boot application's entry point.
 *
 * @author stepio
 */
@SpringBootApplication(scanBasePackages = {"org.stepio.strings"})
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
