#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * The applications main class for this Spring Boot application.
 */
@SpringBootApplication
@Import({ SecurityConfiguration.class })
@ComponentScan(basePackages = {"${package}.${artifactId}", "org.eclipse.scout.boot"})
public class Application {

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}
}