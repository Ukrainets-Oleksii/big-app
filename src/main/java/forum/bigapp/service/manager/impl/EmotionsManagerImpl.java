package forum.bigapp.service.manager.impl;

import forum.bigapp.service.manager.EmotionsManager;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmotionsManagerImpl<T> implements EmotionsManager<T> {
    public final Map<T, Map<String, Boolean>> emotionsMap = new HashMap<>();

    //TODO!!!

    @Override
    public void doEmotion(T entity, String username) {
        if (!hasEmotion(entity, username)) {
            emotionsMap.get(entity).put(username, true);
        } else {
            removeEmotion(entity, username);
            emotionsMap.get(entity).put(username, true);
        }
    }

    @Override
    public int getCountOfEmotionsForEntity(T entity) {
        int count = 0;
        for (boolean value : emotionsMap.get(entity).values()) {
            if (value) {
                count++;
            }
        }
        return count;
    }

    private void removeEmotion(T entity, String username) {
        emotionsMap.get(entity).remove(username);
    }

    private boolean hasEmotion(T entity, String username) {
        if (!emotionsMap.containsKey(entity)) {
            emotionsMap.put(entity, new HashMap<>());
        }
        return emotionsMap.containsKey(entity)
                && emotionsMap.get(entity).containsKey(username);
    }
}
