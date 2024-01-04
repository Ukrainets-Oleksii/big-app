package forum.bigapp.dto.request;

import lombok.Data;
import java.util.List;

@Data
public class UserRequestDto {
    private String username;
    private String password;
    private String description;
    private boolean isDeleted;
    private List<Long> commentsId;
    private List<Long> topicsId;
}
