package choizeus.study.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
public class SessionInfoAPIController {
    @GetMapping("/session-info")
    public String sessionInfo(HttpServletRequest request){
        HttpSession session=request.getSession(false);
        if(session==null){
            return "세션이 없습니다. 로그인을 시도하시오. jenkins-test23신동훈";
        }
        System.out.println(session.getAttributeNames());//HttpSession 객체에서 현재 세션에 저장된 모든 속성의 이름(키)을 가져오는데 사용되는 메서드
        session.getAttributeNames().asIterator().forEachRemaining(name->log.info("session name={},value={}",name,session.getAttribute(name)));
        //name에는 loginMember가 들어간다.,session.getAttribute(name)에는
        log.info("sessionId={}",session.getId());//031AF55
        log.info("maxInactiveInterval={}",session.getMaxInactiveInterval());
        log.info("creationTime={}",session.getCreationTime());
        log.info("lastAccessedTime={}",new Date(session.getLastAccessedTime()));
        log.info("isNew={}",session.isNew());
        return "로그인 세션이 존재합니다.";
    }
}