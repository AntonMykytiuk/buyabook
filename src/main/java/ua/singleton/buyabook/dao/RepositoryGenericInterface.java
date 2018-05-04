package ua.singleton.buyabook.dao;

import java.util.List;

public interface RepositoryGenericInterface<E> {
    E getById(Long id);
    List<E> getAll();
    void create(E entity);
    void update(E entity);
    void removeById(Long id);
}
