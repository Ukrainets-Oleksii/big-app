package forum.bigapp.controller;

import forum.bigapp.dto.request.UserRequestDto;
import forum.bigapp.dto.response.UserResponseDto;
import forum.bigapp.mapper.UserMapper;
import forum.bigapp.model.Role;
import forum.bigapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService service;
    private final UserMapper mapper;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public UserResponseDto createAdmin(@RequestBody @Valid UserRequestDto dto) {
        return mapper.toDto(service.saveAdmin(mapper.toModel(dto)));
    }

    @GetMapping("/{id}")
    public UserResponseDto findById(@PathVariable Long id) {
        return mapper.toDto(service.getByID(id));
    }

    @Deprecated //TODO
    @GetMapping("/findAll")
    public List<UserResponseDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @PutMapping("/{id}")
    public UserResponseDto update(@PathVariable Long id,
                                  @RequestBody @Valid UserRequestDto dto) {
        return mapper.toDto(service.update(id, mapper.toModel(dto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
