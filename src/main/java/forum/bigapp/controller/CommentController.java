package forum.bigapp.controller;

import forum.bigapp.dto.request.CommentRequestDto;
import forum.bigapp.dto.response.CommentResponseDto;
import forum.bigapp.mapper.CommentMapper;
import forum.bigapp.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
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
@RequestMapping("/comments")
@RestController
public class CommentController {
    private final CommentService service;
    private final CommentMapper mapper;

    @PostMapping("/create")
    public CommentResponseDto create(
            @RequestBody @Valid CommentRequestDto dto) {
        return mapper.toDto(service.save(mapper.toModel(dto)));
        //TODO пофіксити зберігання комента без юзера like update
    }

    @GetMapping("/findAll")
    public List<CommentResponseDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public CommentResponseDto findById(@PathVariable Long id) {
        return mapper.toDto(service.getByID(id));
    }

    @PutMapping("/{id}")
    public CommentResponseDto update(@PathVariable Long id,
                                     @RequestBody @Valid CommentRequestDto requestDto) {
        return mapper.toDto(service.update(id, mapper.toModel(requestDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
