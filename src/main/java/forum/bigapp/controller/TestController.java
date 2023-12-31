package forum.bigapp.controller;

import forum.bigapp.dto.request.CommentRequestDto;
import forum.bigapp.dto.request.ReplyRequestDto;
import forum.bigapp.dto.request.TopicRequestDto;
import forum.bigapp.dto.request.UserRequestDto;
import forum.bigapp.dto.response.CommentResponseDto;
import forum.bigapp.dto.response.ReplyResponseDto;
import forum.bigapp.dto.response.TopicResponseDto;
import forum.bigapp.dto.response.UserResponseDto;
import forum.bigapp.mapper.CommentMapper;
import forum.bigapp.mapper.ReplyMapper;
import forum.bigapp.mapper.TopicMapper;
import forum.bigapp.mapper.UserMapper;
import forum.bigapp.service.CommentService;
import forum.bigapp.service.ReplyService;
import forum.bigapp.service.TopicService;
import forum.bigapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/test")
@RestController
public class TestController {
    private final CommentService commentService;
    private final ReplyService replyService;
    private final UserService userService;
    private final TopicService topicService;

    private final CommentMapper commentMapper;
    private final ReplyMapper replyMapper;
    private final UserMapper userMapper;
    private final TopicMapper topicMapper;

    @PostMapping("/create/user")
    public UserResponseDto createUser(@RequestBody UserRequestDto dto) {
        return userMapper.toDto(userService.save(userMapper.toModel(dto)));
    }

    @PostMapping("/create/comment")
    public CommentResponseDto createComment(@RequestBody CommentRequestDto dto) {
        return commentMapper.toDto(commentService.save(commentMapper.toModel(dto)));
    }

    @PostMapping("/create/topic")
    public TopicResponseDto createTopic(@RequestBody TopicRequestDto dto) {
        return topicMapper.toDto(topicService.save(topicMapper.toModel(dto)));
    }

    @PostMapping("/create/reply")
    public ReplyResponseDto createReply(@RequestBody ReplyRequestDto dto) {
        return replyMapper.toDto(replyService.save(replyMapper.toModel(dto)));
    }

    @GetMapping("/find/user")
    public List<UserResponseDto> findAllUser() {
        return userService.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }

    @GetMapping("/find/topic")
    public List<TopicResponseDto> findAllTopic() {
        return topicService.findAll().stream()
                .map(topicMapper::toDto)
                .toList();
    }

    @GetMapping("/find/reply")
    public List<ReplyResponseDto> findAllReply() {
        return replyService.findAll().stream()
                .map(replyMapper::toDto)
                .toList();
    }

    @GetMapping("/find/comment")
    public List<CommentResponseDto> findAllComment() {
        return commentService.findAll().stream()
                .map(commentMapper::toDto)
                .toList();
    }

    @DeleteMapping("/delete/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
