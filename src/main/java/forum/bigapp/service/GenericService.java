package forum.bigapp.service;

import java.util.List;

public interface GenericService<T> {
    T save(T entity);
    T getByID(Long id);
    T update(T entity);
    List<T> findAll();
    void deleteById(Long id);
}
