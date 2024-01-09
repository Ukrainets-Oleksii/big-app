package forum.bigapp.dto.request;

import forum.bigapp.validation.annotations.Email;
import forum.bigapp.validation.annotations.FieldMatch;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@FieldMatch(first = "password", second = "repeatPassword", message = "Passwords are not the same")
public class UserRegistrationRequestDto {
    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min = 8, max = 16)
    private String password;
    @NotNull
    @Size(min = 6, max = 16)
    private String repeatPassword;
    @NotNull
    @Size(max = 25)
    private String username;
    @Size(max = 1000)
    private String description;
}
