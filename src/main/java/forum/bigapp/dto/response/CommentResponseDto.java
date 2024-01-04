package forum.bigapp.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class CommentResponseDto {
    private Long id;
    private String content;
    private boolean isDeleted;
    private Long ownerId;
    private Long topicId;
    private List<Long> repliesId;
}
