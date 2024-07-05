package choizeus.study.controller;

import choizeus.study.Service.LoginService;
import choizeus.study.domain.Member;
import choizeus.study.dto.MemberLoginDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@Slf4j
public class LoginAPIController {
    private final LoginService loginService;

    @CrossOrigin(origins = "<http://116.121.184.161/:3000>")
    @PostMapping("/login_try")
    public String loginBySession(@RequestBody MemberLoginDto memberSignInDto, HttpServletRequest request){

        Member loginMember=loginService.login(memberSignInDto.getLoginId(), memberSignInDto.getPassword());
        log.info("[LoginAPIController] loginBySession : login {}",loginMember);
        if(loginMember==null){
            log.info("[LoginAPIController] loginBySession : login fail");
            return "오류 발생";
        }
        HttpSession session=request.getSession();//세션이 있으면 있는 세션 반환, 없으면 신규 생성 default가 true이고 true일 떄
        //request.getSession(false):세션이 없으면 새로운 세션 생성 X, 세션이 있으면 반환
        session.setAttribute("loginMember",loginMember);//하나의 세션에 여러 값을 저장할 수 있다.,session에 loginMember라는 속성 추가
        log.info("[LoginAPIController] loginBySession : login success");
        return "로그인 성공";
    }

    @PostMapping("/logout")
    public String logoutBySession(HttpServletRequest request){
        HttpSession session=request.getSession();
        if(session!=null){
            session.invalidate();//세션 제거
        }
        log.info("[LoginAPIController] logoutBySession : logout success");
        return "로그아웃 완료";
    }
}