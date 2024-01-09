package forum.bigapp.dto.request;

import forum.bigapp.validation.annotations.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserLoginRequestDto {
    @Email
    @NotNull
    private String email;
    @NotNull @Size(min = 8, max = 16)
    private String password;
}