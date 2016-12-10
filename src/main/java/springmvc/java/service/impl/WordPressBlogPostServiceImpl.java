package springmvc.java.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;
import springmvc.java.service.BlogPostService;

import java.util.List;

/**
 * Created by ziga on 11/6/16.
 */
public class WordPressBlogPostServiceImpl implements BlogPostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WordPressBlogPostServiceImpl.class);

    @Override
    public void savePost(BlogPost blogPost) {

        LOGGER.debug("WordPressBlogPostService savePost is called");
    }

    @Override
    public void saveAsDraft(BlogPost blogPost) {

    }

    @Override
    public void deletePost(BlogPost blogPost) {

    }

    @Override
    public List<BlogPost> listAllBlogPostByUserAndDraftStatus(User user, boolean draft) {
        return null;
    }

    @Override
    public List<BlogPost> listAllBlogPostByUserAndTitleLike(User user, String title) {
        return null;
    }

    @Override
    public BlogPost findBlogPostById(long id) {
        return null;
    }
}
