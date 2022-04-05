package ntnu.stud.tobakken.oving5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Oving5Application {

	public static void main(String[] args) {
		SpringApplication.run(Oving5Application.class, args);
	}

}
