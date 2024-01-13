package forum.bigapp.service.impl;

import forum.bigapp.config.Config;
import forum.bigapp.model.Comment;
import forum.bigapp.model.Reply;
import forum.bigapp.model.User;
import forum.bigapp.repository.ReplyRepository;
import forum.bigapp.service.CommentService;
import forum.bigapp.service.ReplyService;
import forum.bigapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
    private final ReplyRepository repository;
    private final CommentService commentService;
    private final UserService userService;

    @Override
    public Reply save(Reply entity) {
        entity.setTimestamp(LocalDateTime.now().format(Config.format));
        Reply reply = repository.save(entity);
        setReplyToComment(entity);
        setReplyToUser(entity);
        return reply;
    }

    @Override
    public Reply getByID(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public List<Reply> findRepliesByOwner(User user) {
        return repository.findRepliesByOwner(user);
    }

    @Override
    public Reply update(Long id, Reply entity) {
        Reply reply = getByID(id);
        reply.setContent(entity.getContent());

        return repository.save(reply);
    }

    @Override
    public List<Reply> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        Reply reply = getByID(id);
        reply.setDeleted(true);
        update(id, reply);
    }

    private void setReplyToComment(Reply entity) {
        Comment comment = commentService.getByID(entity.getHeadComment().getId());
        comment.getReplies().add(entity);
        commentService.update(comment.getId(), comment);
    }

    private void setReplyToUser(Reply entity) {
        User user = userService.getByID(entity.getOwner().getId());
        user.getReplies().add(entity);
        userService.update(user.getId(), user);
    }
}

