package springmvc.java.service;

import springmvc.java.domain.User;

/**
 * Created by ziga on 11/30/16.
 */
public interface UserService {
    User findUserById(long id);
    User findUserWithBlogPostByUsername(String username);
}
