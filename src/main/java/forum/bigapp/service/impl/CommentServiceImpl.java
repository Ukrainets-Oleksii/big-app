package forum.bigapp.service.impl;

import forum.bigapp.config.Config;
import forum.bigapp.model.Comment;
import forum.bigapp.model.Topic;
import forum.bigapp.model.User;
import forum.bigapp.repository.CommentRepository;
import forum.bigapp.service.CommentService;
import forum.bigapp.service.TopicService;
import forum.bigapp.service.UserService;
import forum.bigapp.service.manager.EmotionsManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository repository;
    private final UserService userService;
    private final TopicService topicService;
    private final EmotionsManager<Comment> emotionsManager;

    @Override
    public Comment save(Comment entity) {
        entity.setTimestamp(LocalDateTime.now().format(Config.format));
        Comment comment = repository.save(entity);
        setCommentToUser(entity);
        setCommentToTopic(entity);
        return comment;
    }

    @Override
    public Comment getByID(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public List<Comment> findCommentsByOwner(User user) {
        return repository.findCommentsByOwner(user);
    }

    //TODO how to get topic for add emotion
    @Override
    public void doEmotion(Long commentId, String username) {
        Comment comment = getByID(commentId);
        emotionsManager.doEmotion(comment, username);
        comment.setCountOfEmotions(
                emotionsManager.getCountOfEmotionsForEntity(comment));
    }

    @Override
    public Comment update(Long id, Comment update) {
        Comment comment = getByID(id);
        setFlag(comment, update);
        comment.setContent(update.getContent());
        return repository.save(comment);
    }

    @Override
    public List<Comment> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        Comment comment = getByID(id);
        comment.setDeleted(true);
        update(id, comment);
    }

    private void setCommentToUser(Comment entity) {
        User user = userService.getByID(entity.getOwner().getId());
        user.getComments().add(entity);
        userService.update(user.getId(), user);
    }

    private void setCommentToTopic(Comment entity) {
        Topic topic = topicService.getByID(entity.getTopic().getId());
        topic.getComments().add(entity);
        topicService.update(topic.getId(), topic);
    }

    private void setFlag(Comment entity, Comment update) {
        if (!(entity.getContent().equals(update.getContent()))) {
            entity.setFlagEditedContent(true);
        }
    }
}
