package forum.bigapp.service;

import forum.bigapp.model.Comment;
import forum.bigapp.model.User;

import java.util.List;

public interface CommentService extends GenericService<Comment> {
    List<Comment> findCommentsByOwner(User user);

    void doEmotion(Long commentId, String username);
}
