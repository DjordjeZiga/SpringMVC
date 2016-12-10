package springmvc.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmvc.java.dao.UserDAO;
import springmvc.java.domain.User;
import springmvc.java.service.UserService;

/**
 * Created by ziga on 11/30/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;

    @Override
    public User findUserById(long id) {
        return userDao.findOne(id);
    }

    @Override
    public User findUserWithBlogPostByUsername(String username) {

        return userDao.findUserByUsername(username);
    }
}
