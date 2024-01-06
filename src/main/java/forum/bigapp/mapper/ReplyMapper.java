package forum.bigapp.mapper;

import forum.bigapp.config.MapperConfig;
import forum.bigapp.dto.request.ReplyRequestDto;
import forum.bigapp.dto.response.ReplyResponseDto;
import forum.bigapp.model.Reply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class, uses = {CommentMapper.class, UserMapper.class})
public interface ReplyMapper {
    @Mapping(source = "headComment.id", target = "headCommentId")
    @Mapping(source = "owner.id", target = "ownerId")
    ReplyResponseDto toDto(Reply reply);

    @Mapping(source = "headCommentId", target = "headComment", qualifiedByName = "commentById")
    @Mapping(source = "ownerId", target = "owner", qualifiedByName = "userById")
    Reply toModel(ReplyRequestDto dto);
}
