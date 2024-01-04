package forum.bigapp.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class UserResponseDto {
    private Long id;
    private String username;
    private String password;
    private String description;
    private boolean isDeleted;
    private List<Long> commentsId;
    private List<Long> topicsId;
}
