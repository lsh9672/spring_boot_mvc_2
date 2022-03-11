package hello.login.web.session;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Slf4j
@RestController
public class SessionInfoController {

    @GetMapping("session-info")
    public String sessionInfo(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session == null){
            return "세션이 없습니다.";
        }

        session.getAttributeNames().asIterator()
                .forEachRemaining(name -> log.info("session name = {}, value={}",name,session.getAttribute(name)));

        log.info("sessionId={}", session.getId());
        //세션 유지시간(초)
        log.info("MaxInactiveInterval={}",session.getMaxInactiveInterval());
        //세션생성된 시간
        log.info("creationTime={}", new Date(session.getCreationTime()));
        //마지막에 세션에 접근한 시간
        log.info("lastAccessedTime={}", new Date(session.getLastAccessedTime()));
        log.info("isNew={}",session.isNew());

        return "세션 출력";
    }
}
