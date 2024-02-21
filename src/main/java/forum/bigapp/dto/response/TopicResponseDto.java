package forum.bigapp.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class TopicResponseDto {
    private Long id;
    private String content;
    private String timestamp;
    private int countOfEmotions;
    private boolean flagEditedContent;
    private Long ownerId;
    private List<Long> commentsId;
}
