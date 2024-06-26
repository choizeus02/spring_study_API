package choizeus.study.Service;


import choizeus.study.domain.Member;
import choizeus.study.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;

    public Member login(String loginId,String password){
        Member member= memberRepository.findByLoginId(loginId);
        if(member.getPassword().equals(password)){
            return member;
        }
        else{
            return null;
        }
    }
}