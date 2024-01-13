package forum.bigapp.service;

import forum.bigapp.model.Reply;
import forum.bigapp.model.User;
import java.util.List;

public interface ReplyService extends GenericService<Reply> {
    List<Reply> findRepliesByOwner(User user);
}
