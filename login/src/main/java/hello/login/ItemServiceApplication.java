package hello.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class ItemServiceApplication {

	public static void main(String[] args) {

		Locale.setDefault(Locale.KOREAN);
		SpringApplication.run(ItemServiceApplication.class, args);
	}

}
