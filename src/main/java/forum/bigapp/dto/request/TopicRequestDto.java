package forum.bigapp.dto.request;

import lombok.Data;
import java.util.List;

@Data
public class TopicRequestDto {
    private String content;
    private boolean isDeleted;
    private Long ownerId;
    private List<Long> commentsId;
}
