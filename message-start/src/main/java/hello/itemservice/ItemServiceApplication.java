package hello.itemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

@SpringBootApplication
public class ItemServiceApplication {

	public static void main(String[] args) {


		SpringApplication.run(ItemServiceApplication.class, args);
		Locale.setDefault(Locale.KOREA);
		System.out.println(Locale.getDefault());
	}
	//스프링 부트가 이것을 자동으로 등록하기 때문에, 직접 빈으로 등록할 필요가 없음
//	@Bean
//	public MessageSource messageSource() {
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasenames("messages", "errors");
//		messageSource.setDefaultEncoding("utf-8");
//		return messageSource;
//	}

}
