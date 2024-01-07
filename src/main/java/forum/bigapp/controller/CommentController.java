package forum.bigapp.controller;

import forum.bigapp.dto.request.CommentRequestDto;
import forum.bigapp.dto.response.CommentResponseDto;
import forum.bigapp.mapper.CommentMapper;
import forum.bigapp.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/comments")
@RestController
public class CommentController {
    private final CommentService service;
    private final CommentMapper mapper;

    @PostMapping("/create")
    public CommentResponseDto createComment(@RequestBody CommentRequestDto dto) {
        return mapper.toDto(service.save(mapper.toModel(dto)));
    }

    @GetMapping("/findAll")
    public List<CommentResponseDto> findAllComment() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public CommentResponseDto getById(@PathVariable Long id) {
        return mapper.toDto(service.getByID(id));
    }

    @PutMapping("/{id}")
    public CommentResponseDto update(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        return mapper.toDto(service.update(id, mapper.toModel(requestDto)));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteById(id);
    }
}
