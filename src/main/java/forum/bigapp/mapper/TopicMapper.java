package forum.bigapp.mapper;

import forum.bigapp.config.MapperConfig;
import forum.bigapp.dto.request.TopicRequestDto;
import forum.bigapp.dto.response.TopicResponseDto;
import forum.bigapp.model.Comment;
import forum.bigapp.model.Topic;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import java.util.List;
import java.util.Optional;

@Mapper(config = MapperConfig.class, uses = {UserMapper.class})
public interface TopicMapper {
    @Mapping(source = "owner.id", target = "ownerId")
    @Mapping(target = "commentsId", ignore = true)
    TopicResponseDto toDto(Topic topic);

    @AfterMapping
    default void setCommentsId(@MappingTarget TopicResponseDto dto, Topic topic) {
        List<Long> commentId = topic.getComments()
                .stream()
                .map(Comment::getId)
                .toList();
        dto.setCommentsId(commentId);
    }

    @Mapping(source = "ownerId", target = "owner", qualifiedByName = "userById")
    @Mapping(target = "comments", ignore = true)
    Topic toModel(TopicRequestDto dto);

    @AfterMapping
    default void setComments(@MappingTarget Topic topic, TopicRequestDto dto) {
        List<Comment> commentId = dto.getCommentsId()
                .stream()
                .map(Comment::new)
                .toList();
        topic.setComments(commentId);
    }

    @Named("topicById")
    default Topic topicById(Long id) {
        return Optional.ofNullable(id)
                .map(Topic::new)
                .orElse(null);
    }
}
