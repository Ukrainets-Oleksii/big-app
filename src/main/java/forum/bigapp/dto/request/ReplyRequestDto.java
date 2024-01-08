package forum.bigapp.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReplyRequestDto {
    @NotNull
    private String content;
    @NotNull
    private Long headCommentId;
    @NotNull
    private Long ownerId;
}
