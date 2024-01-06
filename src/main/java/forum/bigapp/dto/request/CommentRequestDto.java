package forum.bigapp.dto.request;

import lombok.Data;
import java.util.List;

@Data
public class CommentRequestDto {
    private String content;
    private Long ownerId;
    private Long topicId;
    private List<Long> repliesId;
}
