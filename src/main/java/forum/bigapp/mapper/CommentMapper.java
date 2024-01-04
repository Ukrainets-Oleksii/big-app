package forum.bigapp.mapper;

import forum.bigapp.dto.request.CommentRequestDto;
import forum.bigapp.dto.response.CommentResponseDto;
import forum.bigapp.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;

@Mapper(config = MapperConfig.class)
public interface CommentMapper {
    CommentResponseDto toDto(Comment comment);
    Comment toModel(CommentRequestDto dto);
}
