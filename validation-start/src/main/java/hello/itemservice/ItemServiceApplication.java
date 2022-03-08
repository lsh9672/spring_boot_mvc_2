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
		//JVM의 디폴트 로케일정보가 en_US, 이므로 스프링 부트 실행전에 이를 ko로 바꿔준다.
		Locale.setDefault(Locale.KOREA);
		SpringApplication.run(ItemServiceApplication.class, args);
	}

//	@Bean
//	public MessageSource messageSource(){
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasenames("messages","error");
//
//		messageSource.setDefaultEncoding("utf-8");
//		return messageSource;
//	}

}
