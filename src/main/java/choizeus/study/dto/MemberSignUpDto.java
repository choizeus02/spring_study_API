package choizeus.study.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class MemberSignUpDto {
    @NotEmpty
    private String name;

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String password;
}