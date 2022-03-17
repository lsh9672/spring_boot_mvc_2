package hello.typeconverter.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


//string은 기본으로 제공되기 때문에 이를 제외한 것들을 넣어준다.(ex,Number - int,double등과 같은것들이 이것의 자식임, 따라서 이거 하나 넣으면 다 들어가는거,)
@Slf4j
public class MyNumberFormatter implements Formatter<Number> {
    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        log.info("text={}, locale={}",text,locale);
        //"1,000" -> 1000
        //원래는 이런식으로 포매팅할떄 로케일 정보도 고려해야되서 굉장히 복잡한데, 스프링이 다 제공해줌.

        return NumberFormat.getInstance(locale).parse(text);
    }

    @Override
    public String print(Number object, Locale locale) {

        log.info("object={}, locale={}", object,locale);
        return NumberFormat.getInstance(locale).format(object);
    }
}
