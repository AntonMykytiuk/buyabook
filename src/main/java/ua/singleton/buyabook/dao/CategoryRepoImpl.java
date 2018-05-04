package ua.singleton.buyabook.dao;

import org.springframework.stereotype.Repository;
import ua.singleton.buyabook.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CategoryRepoImpl implements CategoryRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Category getById(Long id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Category> getAll() {
        return entityManager.createQuery("SELECT c FROM Category c").getResultList();
    }

    @Override
    public void create(Category category) {
        entityManager.persist(category);
    }

    @Override
    public void update(Category category) {
        entityManager.merge(category);
    }

    @Override
    public void removeById(Long id) {
        Query query = entityManager.createQuery("DELETE FROM Category c WHERE c.id = :id");
        query.setParameter("id", id).executeUpdate();
    }
}
