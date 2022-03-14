package hello.login.web.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Slf4j
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("log filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("log filter doFilter");

        //ServketRequest에는 기능이 별로 없기 때문에 다운캐스팅해서 기능이 더 많은 자식 클래스를 사용해야됨.
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        String uuid = UUID.randomUUID().toString();

        try{
            log.info("REQUEST [{}][{}]", uuid,requestURI);
            //있으면 다음 필터 호출, 없으면 서블릿 호출 - 없으면 서블릿 호출안됨.
            chain.doFilter(request,response);
        } catch(Exception e){
            throw e;
        } finally{
            //여기가 호출되면 다 끝났다는 뜻
            log.info("RESPONSE [{}][{}]", uuid, requestURI);
        }
    }

    @Override
    public void destroy() {
        log.info("log filter destroy");
    }
}
