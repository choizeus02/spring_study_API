package choizeus.study.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "loginId",nullable = false)
    private String loginId;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "password",nullable = false)
    private String password;

    public Member(String name,String loginId,String password){
        this.name=name;
        this.loginId=loginId;
        this.password=password;
    }
}
