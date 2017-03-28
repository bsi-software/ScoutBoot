package org.eclipse.scout.boot.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.eclipse.scout.boot.platform")
public class ScoutBootTestApplication {

	public static void main(final String[] args) {
		SpringApplication.run(ScoutBootTestApplication.class, args);
	}

}
