package forum.bigapp.dto.request;

import lombok.Data;

@Data
public class ReplyRequestDto {
    private String content;
    private Long headCommentId;
    private Long ownerId;
}
