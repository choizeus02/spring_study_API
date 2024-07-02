package choizeus.study.controller;

import choizeus.study.domain.Member;
import choizeus.study.dto.MemberSignUpDto;
import choizeus.study.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
@Slf4j
public class MemberAPIController {
    private final MemberRepository memberRepository;
    @PostMapping("/add")
    public String memberSignUp(@RequestBody @Valid MemberSignUpDto memberSignUpDto){
        Member member=new Member(memberSignUpDto.getName(),memberSignUpDto.getLoginId(),memberSignUpDto.getPassword());
        memberRepository.save(member);
        log.info("[MemberAPIController] memberSignUp : member {}",member.getLoginId());
        log.info("[MemberAPIController] memberSignUp : signUp success");
        return "저장되었습니다";
    }

    @GetMapping("/homeBySession")
    public String homeLoginBySession(HttpServletRequest request){
        HttpSession session= request.getSession(false);
        if(session==null){
            return "기본 홈 화면";
        }
        Member loginMember=(Member)session.getAttribute("loginMember");
        if(loginMember==null){
            return "기본 홈 화면";
        }
        log.info("[MemberAPIController] homeLoginBySession : session test");
        return loginMember.getName()+"을 위한 기본 홈 화면";
    }




}