package SpringBoot.app.spa.service;


import SpringBoot.app.spa.UserDao.UserDao;
import SpringBoot.app.spa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersService {

    private UserDao userDao;

    @Autowired
    public UsersService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Transactional
    public void addUser(User user) {
        userDao.createUser(user);
    }

    @Transactional
    public void editUser(int id, User updatedUser) {
        updatedUser.setId(id);
        userDao.updateUser(updatedUser);
    }

    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
