package forum.bigapp.dto.response;

import lombok.Data;

@Data
public class UserRegistrationResponseDto {
    private Long id;
    private String email;
    private String username;
    private String description;
}
