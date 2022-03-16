package hello.exception.resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try{
            if(ex instanceof IllegalArgumentException){
                //발생한 500예외를 여기서 받아서 400에러로 만든다음 ModelAndView를 반환해서 400에러로 인식하게 만들어버림.
                //서블릿 컨테이너(was)는 이제 에러를 400으로 인식함.록
                //Exception을 sendError로 바꿔치기한것.
                log.info("IllegalArgumentException resolver to 400");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
                return new ModelAndView();
            }

            //json으로 동작하게 만들수도 있음
//            if (ex ...){
//                response.getWriter().println({"as":"asdf"})
//            }
        } catch(IOException e){
            e.printStackTrace();
        }
        //다음 exceptionResolver를 찾아보고 다른 것들도 전부 null이라면, 받은 예외를 그대로 다시 날려버림.
        return null;

    }
}
