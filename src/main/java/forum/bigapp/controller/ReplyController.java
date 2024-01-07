package forum.bigapp.controller;

import forum.bigapp.dto.request.ReplyRequestDto;
import forum.bigapp.dto.response.ReplyResponseDto;
import forum.bigapp.mapper.ReplyMapper;
import forum.bigapp.service.ReplyService;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/replies")
@RestController
public class ReplyController {
    private final ReplyService service;
    private final ReplyMapper mapper;

    @PostMapping("/create")
    public ReplyResponseDto create(@RequestBody ReplyRequestDto dto) {
        return mapper.toDto(service.save(mapper.toModel(dto)));
    }

    @GetMapping("/findAll")
    public List<ReplyResponseDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ReplyResponseDto findById(@PathVariable Long id) {
        return mapper.toDto(service.getByID(id));
    }

    @PutMapping("/{id}")
    public ReplyResponseDto update(@PathVariable Long id, @RequestBody ReplyRequestDto requestDto) {
        return mapper.toDto(service.update(id, mapper.toModel(requestDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
