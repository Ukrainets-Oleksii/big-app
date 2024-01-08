package forum.bigapp.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

@Data
public class UserRequestDto {
    @Email //TODO
    @NotNull
    private String email;
    //TODO @NotEqual
    @NotNull
    private String username;
    @NotNull
//    @Min(8)
//    @Max(16)
    private String password;
    @NotNull
//    @Max(1000)
    private String description;
    private List<Long> commentsId;
    private List<Long> topicsId;
    private List<Long> repliesId;
}
