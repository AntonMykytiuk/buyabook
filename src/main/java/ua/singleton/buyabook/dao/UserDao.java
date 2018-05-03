package ua.singleton.buyabook.dao;

import ua.singleton.buyabook.model.User;

import java.util.List;

public interface UserDao {
    User getUserById(long id);
    List<User> getAllUsers();
    void addUser(User user);
    void updateUser(User user);
    void removeUserById(long id);
}
