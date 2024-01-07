package forum.bigapp.controller;

import forum.bigapp.dto.request.TopicRequestDto;
import forum.bigapp.dto.response.TopicResponseDto;
import forum.bigapp.mapper.TopicMapper;
import forum.bigapp.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/replies")
@RestController
public class TopicController {
    TopicService service;
    TopicMapper mapper;

    @PostMapping("/create")
    public TopicResponseDto create(@RequestBody TopicRequestDto dto) {
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
    public TopicResponseDto update(@PathVariable Long id, @RequestBody TopicRequestDto requestDto) {
        return mapper.toDto(service.update(id, mapper.toModel(requestDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
