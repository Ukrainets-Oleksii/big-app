package forum.bigapp.mapper;

import forum.bigapp.dto.request.UserRequestDto;
import forum.bigapp.dto.response.UserResponseDto;
import forum.bigapp.model.User;
import forum.bigapp.service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserResponseDto toDto(User user);
    User toModel(UserRequestDto dto);

    @Named("ownerById")
    default User userById(Long id) {
        return Optional.ofNullable(id)
                .map(User::new)
                .orElse(null);
    }
}
