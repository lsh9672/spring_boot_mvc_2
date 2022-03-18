package hello.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class UploadApplication {

	public static void main(String[] args) {

		Locale.setDefault(Locale.KOREAN);
		SpringApplication.run(UploadApplication.class, args);
	}

}
