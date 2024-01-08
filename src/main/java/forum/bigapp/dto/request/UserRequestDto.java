package forum.bigapp.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Size(min = 8, max = 16)
    private String password;
    @NotNull
    @Size(max = 1000)
    private String description;
    private List<Long> commentsId;
    private List<Long> topicsId;
    private List<Long> repliesId;
}
