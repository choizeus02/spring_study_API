package choizeus.study.config;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Slf4j
public class LogCheckFilter implements Filter {

    private static final String[] whitelist={"/members/add","/members/homeBySession","/members/homeByCookie","/loginByCookie","/logoutByCookie","/loginBySession","/logoutBySession"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest=(HttpServletRequest) request;
        String requestURI=httpRequest.getRequestURI();
        HttpServletResponse httpResponse=(HttpServletResponse) response;
        try{
            log.info("인증 체크 필터 시작 {}",requestURI);
            if(isLoginCheckPath(requestURI)){
                log.info("인증 체크 로직 실행 {}",requestURI);
                HttpSession session=httpRequest.getSession(false);
                Cookie[]cookies=httpRequest.getCookies();
                if(cookies!=null){
                    for (Cookie cookie : cookies) {
                        log.info("cookie의 이름 {}",cookie.getName());
                        log.info("cookie의 value {}",cookie.getValue());
                    }
                }
                else{
                    log.info("쿠키는 null입니다");
                } if(session==null||session.getAttribute("loginMember")==null){
                    log.info("미인증 사용자 요청 {}",requestURI);
                    return;
                }
            }
            chain.doFilter(request,response);
        }catch (Exception e){
            throw e;
        }finally {
            log.info("인증 체크 필터 종료 {}",requestURI);
        }
    }
    public boolean isLoginCheckPath(String requestURI){
        return !PatternMatchUtils.simpleMatch(whitelist,requestURI);
    }
}