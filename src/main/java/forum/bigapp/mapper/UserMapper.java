package forum.bigapp.mapper;

import forum.bigapp.config.MapperConfig;
import forum.bigapp.dto.request.UserRequestDto;
import forum.bigapp.dto.response.UserResponseDto;
import forum.bigapp.model.Comment;
import forum.bigapp.model.Topic;
import forum.bigapp.model.Reply;
import forum.bigapp.model.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    @Mapping(target = "commentsId", ignore = true)
    @Mapping(target = "topicsId", ignore = true)
    @Mapping(target = "repliesId", ignore = true)
    UserResponseDto toDto(User user);

    @AfterMapping
    default void setCommentsIdAndTopicsIdAndRepliesId(@MappingTarget
                                                          UserResponseDto dto, User user) {
        if (user.getComments() != null) {
            List<Long> commentsId = user.getComments()
                    .stream()
                    .map(Comment::getId)
                    .toList();
            dto.setCommentsId(commentsId);
        } else {
            dto.setCommentsId(new ArrayList<>());
        }

        if (user.getTopics() != null){
            List<Long> topicsId = user.getTopics()
                    .stream()
                    .map(Topic::getId)
                    .toList();
            dto.setTopicsId(topicsId);
        } else {
            dto.setTopicsId(new ArrayList<>());
        }

        if (user.getReplies() != null){
            List<Long> repliesId = user.getReplies()
                    .stream()
                    .map(Reply::getId)
                    .toList();
            dto.setRepliesId(repliesId);
        } else {
            dto.setRepliesId(new ArrayList<>());
        }
    }

    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "topics", ignore = true)
    @Mapping(target = "replies", ignore = true)
    User toModel(UserRequestDto dto);

    @AfterMapping
    default void setTopicsAndCommentsAndReplies(@MappingTarget
                                                    User user, UserRequestDto dto) {
        if (dto.getCommentsId() != null) {
            List<Comment> comments = dto.getCommentsId()
                    .stream()
                    .map(Comment::new)
                    .toList();
            user.setComments(comments);
        }
//        else {
//            user.setComments(new ArrayList<>());
//        }

        if (dto.getTopicsId() != null) {
            List<Topic> topics = dto.getTopicsId()
                    .stream()
                    .map(Topic::new)
                    .toList();
            user.setTopics(topics);
        }
//        else {
//            user.setTopics(new ArrayList<>());
//        }

        if (dto.getRepliesId() != null) {
            List<Reply> replies = dto.getRepliesId()
                    .stream()
                    .map(Reply::new)
                    .toList();
            user.setReplies(replies);
        }
//        else {
//            user.setReplies(new ArrayList<>());
//        }
    }

    @Named("userById")
    default User userById(Long id) {
        return Optional.ofNullable(id)
                .map(User::new)
                .orElse(null);
    }
}
