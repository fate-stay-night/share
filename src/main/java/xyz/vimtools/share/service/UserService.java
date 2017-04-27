package xyz.vimtools.share.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.vimtools.share.dao.UserDao;
import xyz.vimtools.share.domain.model.User;

/**
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-4-25
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public String addUser(User user) {
        return userDao.insert(user);
    }

    public User findById(String id) {
        return userDao.selectById(id);
    }

    public User findByEmail(String email) {
        return userDao.selectByEmail(email);
    }
}
