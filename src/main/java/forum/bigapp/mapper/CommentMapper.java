package forum.bigapp.mapper;

import forum.bigapp.dto.request.CommentRequestDto;
import forum.bigapp.dto.response.CommentResponseDto;
import forum.bigapp.model.Comment;
import forum.bigapp.model.Reply;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import java.util.List;
import java.util.Optional;

@Mapper(config = MapperConfig.class)
public interface CommentMapper {
    @Mapping(source = "owner.id", target = "ownerId")
    @Mapping(source = "topic.id", target = "topicId")
    @Mapping(target = "repliesId", ignore = true)
    CommentResponseDto toDto(Comment comment);

    @AfterMapping
    default void setRepliesId(@MappingTarget CommentResponseDto dto, Comment comment) {
        List<Long> repliesId = comment.getReplies()
                .stream()
                .map(Reply::getId)
                .toList();
        dto.setRepliesId(repliesId);
    }

    @Mapping(source = "ownerId", target = "owner", qualifiedByName = "userById")
    @Mapping(source = "topicId", target = "topic", qualifiedByName = "topicById")
    @Mapping(target = "replies", ignore = true)
    Comment toModel(CommentRequestDto dto);

    @AfterMapping
    default void setReplies(@MappingTarget Comment comment, CommentRequestDto dto) {
        List<Reply> replies = dto.getRepliesId()
                .stream()
                .map(Reply::new)
                .toList();
        comment.setReplies(replies);
    }

    @Named("commentById")
    default Comment commentById(Long id) {
        return Optional.ofNullable(id)
                .map(Comment::new)
                .orElse(null);
    }
}
