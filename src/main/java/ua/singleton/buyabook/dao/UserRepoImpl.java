package ua.singleton.buyabook.dao;

import org.springframework.stereotype.Repository;
import ua.singleton.buyabook.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepoImpl implements UserRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        return entityManager.createQuery("SELECT u FROM User u").getResultList();
    }

    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeById(Long id) {
        Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id = :id");
        query.setParameter("id", id).executeUpdate();
    }
}
