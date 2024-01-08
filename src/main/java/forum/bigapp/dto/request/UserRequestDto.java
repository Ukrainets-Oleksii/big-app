package forum.bigapp.dto.request;

import lombok.Data;
import java.util.List;

@Data
public class UserRequestDto {
    private String email;
    private String username;
    private String password;
    private String description;
    private List<Long> commentsId;
    private List<Long> topicsId;
    private List<Long> repliesId;
}
