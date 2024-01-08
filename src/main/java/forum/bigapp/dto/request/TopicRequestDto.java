package forum.bigapp.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

@Data
public class TopicRequestDto {
    @NotNull
    private String content;
    @NotNull
    private Long ownerId;
    private List<Long> commentsId;
}
