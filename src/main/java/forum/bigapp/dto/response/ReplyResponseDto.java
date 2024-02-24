package forum.bigapp.dto.response;

import lombok.Data;

@Data
public class ReplyResponseDto {
    private Long id;
    private String content;
    private String timestamp;
    private int countOfEmotions;
    private boolean flagEditedContent;
    private Long headCommentId;
    private Long ownerId;
}
