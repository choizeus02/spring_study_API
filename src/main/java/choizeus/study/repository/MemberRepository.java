package choizeus.study.repository;

import choizeus.study.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    public Member findByLoginId(String loginId);
}
