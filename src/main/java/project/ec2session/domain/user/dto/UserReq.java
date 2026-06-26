package project.ec2session.domain.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import project.ec2session.domain.user.entity.User;

public class UserReq {

    @Schema(description = "회원가입 요청 DTO")
    public record SignUpDto(
            @Schema(description = "사용자 아이디", example = "testuser")
            @NotBlank(message = "아이디는 필수 입력 값입니다.")
            String username,

            @Schema(description = "비밀번호", example = "password1234")
            @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
            String password,

            @Schema(description = "닉네임", example = "테스트유저")
            @NotBlank(message = "닉네임은 필수 입력 값입니다.")
            String nickname
    ) {
        public User toEntity(String encodedPassword) {
            return User.builder()
                    .username(username)
                    .password(encodedPassword)
                    .nickname(nickname)
                    .build();
        }
    }

    @Schema(description = "로그인 요청 DTO")
    public record SignInDto(
            @Schema(description = "사용자 아이디", example = "testuser")
            @NotBlank(message = "아이디는 필수 입력 값입니다.")
            String username,

            @Schema(description = "비밀번호", example = "password1234")
            @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
            String password
    ) { }

    @Schema(description = "사용자 정보 수정 요청 DTO")
    public record UpdateInfo(
            @Schema(description = "변경할 닉네임", example = "새로운닉네임")
            @NotBlank(message = "닉네임은 필수 입력 값입니다.")
            String nickname
    ) { }
}
