package ua.singleton.buyabook.dao;

import org.springframework.stereotype.Repository;
import ua.singleton.buyabook.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Author getAuthorById(long id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    public List<Author> getAllAuthors() {
        return entityManager.createQuery("SELECT a FROM Author a").getResultList();
    }

    @Override
    public void addAuthor(Author author) {

    }

    @Override
    public void updateAuthor(Author author) {

    }

    @Override
    public void removeAuthorById(long id) {

    }
}
