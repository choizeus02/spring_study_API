package choizeus.study.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class MemberLoginDto {
    @NotEmpty
    private String loginId;

    @NotEmpty
    private String password;
}