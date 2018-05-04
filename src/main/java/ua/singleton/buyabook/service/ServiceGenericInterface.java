package ua.singleton.buyabook.service;

import java.util.List;

public interface ServiceGenericInterface<E> {
    E getById(Long id);
    List<E> getAll();
    void create(E entity);
    void update(Long id, E entity);
    void removeById(Long id);
}
