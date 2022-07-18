package projectFinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import java.util.UUID;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		ApplicationContext ctxt = SpringApplication.run(Application.class, args);

		String name = ctxt.getEnvironment().getProperty("spring.application.name");
		System.out.println(name);

		System.out.println(UUID.randomUUID());
	}

}
