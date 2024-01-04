package forum.bigapp.mapper;

import forum.bigapp.dto.request.ReplyRequestDto;
import forum.bigapp.dto.response.ReplyResponseDto;
import forum.bigapp.model.Reply;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;

@Mapper(config = MapperConfig.class)
public interface ReplyMapper {
    ReplyResponseDto toDto(Reply reply);
    Reply toModel(ReplyRequestDto dto);
}
