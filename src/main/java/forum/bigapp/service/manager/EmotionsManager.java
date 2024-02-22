package forum.bigapp.service.manager;

public interface EmotionsManager<T> {

    void doEmotion(T entity, String username);

    int getCountOfEmotionsForEntity(T entity);
}
