package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.ObjectError;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class MessageCodesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    @DisplayName("메시지코드 리졸버 오브젝트")
    public void messageCodesResolverObject() throws Exception{

        String[] strings = codesResolver.resolveMessageCodes("required","item");
        System.out.println("messageCode = "+ Arrays.asList(strings));

        assertThat(strings).containsExactly("required.item","required");
    }

    @Test
    @DisplayName("메시지코드 리졸버 필드")
    public void messageCodesResolverField() throws Exception{
        String[] strings = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
        System.out.println("messageCode = "+ Arrays.asList(strings));

        assertThat(strings).containsExactly("required.item.itemName", "required.itemName", "required.java.lang.String", "required");

    }
}
