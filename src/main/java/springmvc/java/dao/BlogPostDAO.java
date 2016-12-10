package springmvc.java.dao;

import org.springframework.data.repository.CrudRepository;
import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;

import java.util.List;

/**
 * Created by ziga on 11/29/16.
 */
public interface BlogPostDAO extends CrudRepository<BlogPost,Long> {

    List<BlogPost>findAllBlogPostByUserAndTitleContaining(User user,String title);
    List<BlogPost>findAllBlogPostsByUserAndDraft(User user,boolean draft);
}
