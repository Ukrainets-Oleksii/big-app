package forum.bigapp.dto.response;

import lombok.Data;

@Data
public class ReplyResponseDto {
    private Long id;
    private String content;
    private boolean isDeleted;
    private Long headCommentId;
}
