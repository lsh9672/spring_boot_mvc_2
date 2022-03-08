package hello.itemservice.message;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource ms;

    //현재 디폴트 로케일이 en으로 되어있기 때문에, 강의와 동일한 결과를 내기 위해서 디폴트 로케일을 ko로 변경
    @BeforeEach
    public void localeSet(){
        Locale.setDefault(new Locale("ko", "KR"));

        System.out.println("로케일 정보: "+ Locale.getDefault());
    }

    @Test
    @DisplayName("메시지 테스트")
    public void helleMessage(){


        //give
        String result = ms.getMessage("hello", null, null);
        System.out.println("result = " + result);
        //when
        //then
        assertThat(result).isEqualTo("안녕");
//        Assertions.assertThat(result).isEqualTo("hello");
    }

    @Test
    @DisplayName("메시지 코드를 찾지 못함.")
    public void notFoundMessageCode(){
        //give
        assertThatThrownBy(()->ms.getMessage("no_code",null,null))
                .isInstanceOf(NoSuchMessageException.class);
        //when
        //then
    }

    @Test
    @DisplayName("메시지 코드가 없을때 기본메시지")
    public void notFoundMessageCodeDefaultMessage() throws Exception{
        //give
        String result = ms.getMessage("no_code",null,"기본메시지",null);
        //when
        //then
        assertThat(result).isEqualTo("기본메시지");
    }

    @Test
    @DisplayName("arguments 메시지")
    public void argumentMessage() throws Exception{
        //give
        //Argument로 넘긴 메시지가 properties의 {0} 이거 대신에 치환됨
        String message = ms.getMessage("hello.name", new Object[]{"Spring"}, null);
        //when
        //then
        assertThat(message).isEqualTo("안녕 Spring");
    }

    @Test
    @DisplayName("기본언어")
    public void defaultLang() throws Exception{
        //give

        //when
        //then

        assertThat(ms.getMessage("hello",null,null)).isEqualTo("안녕");
        assertThat(ms.getMessage("hello",null,Locale.KOREA)).isEqualTo("안녕");
    }

    @Test
    @DisplayName("영어로 테스트")
    public void enLang() throws Exception{
        //give

        //when
        //then
        assertThat(ms.getMessage("hello",null,Locale.ENGLISH)).isEqualTo("hello");
    }
}
