package springmvc.java.service;

import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;

import java.util.List;

/**
 * Created by ziga on 11/6/16.
 */
public interface BlogPostService {

    void savePost(BlogPost blogPost);
    void saveAsDraft(BlogPost blogPost);
    void deletePost(BlogPost blogPost);
    List<BlogPost> listAllBlogPostByUserAndDraftStatus(User user, boolean draft);
    List<BlogPost> listAllBlogPostByUserAndTitleLike(User user, String title);
    BlogPost findBlogPostById(long id);

}