package forum.bigapp.mapper;

import forum.bigapp.dto.request.UserRequestDto;
import forum.bigapp.dto.response.UserResponseDto;
import forum.bigapp.model.Comment;
import forum.bigapp.model.Topic;
import forum.bigapp.model.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import java.util.List;
import java.util.Optional;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    @Mapping(target = "commentsId", ignore = true)
    @Mapping(target = "topicsId", ignore = true)
    UserResponseDto toDto(User user);

    @AfterMapping
    default void setCommentsIdAndTopicsId(@MappingTarget UserResponseDto dto, User user) {
        List<Long> commentsId = user.getComments()
                .stream()
                .map(Comment::getId)
                .toList();
        dto.setCommentsId(commentsId);

        List<Long> topicsId = user.getTopics()
                .stream()
                .map(Topic::getId)
                .toList();
        dto.setCommentsId(topicsId);
    }

    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "topics", ignore = true)
    User toModel(UserRequestDto dto);

    @AfterMapping
    default void setSubjects(@MappingTarget User user, UserRequestDto dto) {
        List<Comment> comments = dto.getCommentsId()
                .stream()
                .map(Comment::new)
                .toList();
        user.setComments(comments);

        List<Topic> topics = dto.getTopicsId()
                .stream()
                .map(Topic::new)
                .toList();
        user.setTopics(topics);
    }

    @Named("userById")
    default User userById(Long id) {
        return Optional.ofNullable(id)
                .map(User::new)
                .orElse(null);
    }
}
