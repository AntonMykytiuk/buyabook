package ua.singleton.buyabook.dao;

import org.springframework.stereotype.Repository;
import ua.singleton.buyabook.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void removeUserById(long id) {

    }
}
