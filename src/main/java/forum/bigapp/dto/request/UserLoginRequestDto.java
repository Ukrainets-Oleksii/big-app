package forum.bigapp.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserLoginRequestDto {
    @NotNull
    private String username;
    @NotNull @Size(min = 8, max = 16)
    private String password;
}