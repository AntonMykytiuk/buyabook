package ua.singleton.buyabook.dao;

import org.springframework.stereotype.Repository;
import ua.singleton.buyabook.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AuthorRepoImpl implements AuthorRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Author getById(Long id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Author> getAll() {
        return entityManager.createQuery("SELECT a FROM Author a").getResultList();
    }

    @Override
    public void create(Author author) {
        entityManager.persist(author);
    }

    @Override
    public void update(Author author) {
        entityManager.merge(author);
    }

    @Override
    public void removeById(Long id) {
        Query query = entityManager.createQuery("DELETE FROM Author a WHERE a.id = :id");
        query.setParameter("id", id).executeUpdate();
    }
}
