package forum.bigapp.controller;

import forum.bigapp.dto.request.TopicRequestDto;
import forum.bigapp.dto.response.TopicResponseDto;
import forum.bigapp.mapper.TopicMapper;
import forum.bigapp.service.TopicService;
import jakarta.validation.Valid;
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
@RequestMapping("/topics")
@RestController
public class TopicController {
    private final TopicService service;
    private final TopicMapper mapper;

    @PostMapping("/create")
    public TopicResponseDto create(@RequestBody @Valid TopicRequestDto dto) {
        return mapper.toDto(service.save(mapper.toModel(dto)));
    }

    @GetMapping("/findAll")
    public List<TopicResponseDto> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public TopicResponseDto findById(@PathVariable Long id) {
        return mapper.toDto(service.getByID(id));
    }

    @PutMapping("/{id}")
    public TopicResponseDto update(@PathVariable Long id,
                                   @RequestBody @Valid TopicRequestDto requestDto) {
        return mapper.toDto(service.update(id, mapper.toModel(requestDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
