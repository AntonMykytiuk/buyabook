package ua.singleton.buyabook.service;

import org.springframework.stereotype.Service;
import ua.singleton.buyabook.dao.UserRepo;
import ua.singleton.buyabook.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User getById(Long id) {
        return userRepo.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepo.getAll();
    }

    @Override
    public void create(User user) {
        userRepo.create(user);
    }

    @Override
    public void update(Long id, User user) {
        User userFromRepo = userRepo.getById(id);
        userFromRepo.setUsername(user.getUsername());
        userFromRepo.setPassword(user.getPassword());
        userFromRepo.setEnabled(user.isEnabled());
        userFromRepo.setRole(user.getRole());
        userFromRepo.setShoppingCart(user.getShoppingCart());
        userRepo.update(user);
    }

    @Override
    public void removeById(Long id) {
        userRepo.removeById(id);
    }
}
