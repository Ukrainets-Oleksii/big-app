package forum.bigapp.controller;

import forum.bigapp.dto.request.CommentRequestDto;
import forum.bigapp.dto.request.ReplyRequestDto;
import forum.bigapp.dto.response.CommentResponseDto;
import forum.bigapp.dto.response.ReplyResponseDto;
import forum.bigapp.mapper.CommentMapper;
import forum.bigapp.mapper.ReplyMapper;
import forum.bigapp.service.CommentService;
import forum.bigapp.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/test")
@RestController
public class TestController {
    private final CommentService commentService;
    private final ReplyService replyService;

    private final CommentMapper commentMapper;
    private final ReplyMapper replyMapper;

    @PostMapping("/create/comment")
    public CommentResponseDto create(@RequestBody CommentRequestDto dto) {
        return commentMapper.toDto(commentService.save(commentMapper.toModel(dto)));
    }

    @PostMapping("/create/reply")
    public ReplyResponseDto create(@RequestBody ReplyRequestDto dto) {
        return replyMapper.toDto(replyService.save(replyMapper.toModel(dto)));
    }

    @GetMapping("find/reply")
    public List<ReplyResponseDto> findAllReply() {
        return replyService.findAll().stream()
                .map(replyMapper::toDto)
                .toList();
    }

    @GetMapping("find/comment")
    public List<CommentResponseDto> findAllComment() {
        return commentService.findAll().stream()
                .map(commentMapper::toDto)
                .toList();
    }
}
