package forum.bigapp.controller;

import forum.bigapp.dto.request.CommentRequestDto;
import forum.bigapp.dto.request.ReplyRequestDto;
import forum.bigapp.dto.response.CommentResponseDto;
import forum.bigapp.dto.response.ReplyResponseDto;
import forum.bigapp.mapper.ReplyMapper;
import forum.bigapp.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/replies")
@RestController
public class ReplyController {
    ReplyService service;
    ReplyMapper mapper;

    @PostMapping("/create")
    public ReplyResponseDto createComment(@RequestBody ReplyRequestDto dto) {
        return mapper.toDto(service.save(mapper.toModel(dto)));
    }

    @GetMapping("/findAll")
    public List<ReplyResponseDto> findAllComment() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ReplyResponseDto getById(@PathVariable Long id) {
        return mapper.toDto(service.getByID(id));
    }

    @PutMapping("/{id}")
    public ReplyResponseDto update(@PathVariable Long id, @RequestBody ReplyRequestDto requestDto) {
        return mapper.toDto(service.update(id, mapper.toModel(requestDto)));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteById(id);
    }
}
