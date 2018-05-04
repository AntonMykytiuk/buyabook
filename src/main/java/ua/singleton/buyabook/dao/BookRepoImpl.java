package ua.singleton.buyabook.dao;

import org.springframework.stereotype.Repository;
import ua.singleton.buyabook.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookRepoImpl implements BookRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Book getById(Long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> getAll() {
        return entityManager.createQuery("SELECT b FROM Book b").getResultList();
    }

    @Override
    public void create(Book book) {
        entityManager.persist(book);
    }

    @Override
    public void update(Book book) {
        entityManager.merge(book);
    }

    @Override
    public void removeById(Long id) {
        Query query = entityManager.createQuery("DELETE FROM Book b WHERE b.id = :id");
        query.setParameter("id", id).executeUpdate();
    }
}
