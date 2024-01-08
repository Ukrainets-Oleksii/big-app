package forum.bigapp.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

@Data
public class CommentRequestDto {
    @NotNull
    private String content;
    @NotNull
    private Long ownerId;
    @NotNull
    private Long topicId;
    private List<Long> repliesId;
}
