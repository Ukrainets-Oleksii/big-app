package forum.bigapp.mapper;

import forum.bigapp.dto.request.TopicRequestDto;
import forum.bigapp.dto.response.TopicResponseDto;
import forum.bigapp.model.Topic;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Named;
import java.util.Optional;

@Mapper(config = MapperConfig.class)
public interface TopicMapper {

    TopicResponseDto toDto(Topic topic);
    Topic toModel(TopicRequestDto dto);

    @Named("topicById")
    default Topic userById(Long id) {
        return Optional.ofNullable(id)
                .map(Topic::new)
                .orElse(null);
    }
}
