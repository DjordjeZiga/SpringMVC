package springmvc.java.dao;

import org.springframework.data.repository.CrudRepository;
import springmvc.java.domain.User;

/**
 * Created by ziga on 11/30/16.
 */
public interface UserDAO extends CrudRepository<User,Long> {

    User findUserByUsername(String username);
}
