package forum.bigapp.mapper;

import forum.bigapp.config.MapperConfig;
import forum.bigapp.dto.request.ReplyRequestDto;
import forum.bigapp.dto.response.ReplyResponseDto;
import forum.bigapp.model.Reply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class, uses = {CommentMapper.class})
public interface ReplyMapper {
    @Mapping(source = "headComment.id", target = "headCommentId")
    ReplyResponseDto toDto(Reply reply);
    @Mapping(source = "headCommentId", target = "headComment", qualifiedByName = "commentById")
    Reply toModel(ReplyRequestDto dto);
}
