package springmvc.java.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmvc.java.dao.BlogPostDAO;
import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;
import springmvc.java.service.BlogPostService;

import java.util.Date;
import java.util.List;

/**
 * Created by ziga on 11/6/16.
 */
@Service
public class BlogPostServiceImpl implements BlogPostService {

    public static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServiceImpl.class);

    @Autowired
    private BlogPostDAO blogPostDAO;

    @Override
    public void savePost(BlogPost blogPost) {
        LOGGER.debug("BlogPostServiceImpl: savePost is called");
        blogPost.setPublishDate(new Date());
        blogPostDAO.save(blogPost);
    }

    @Override
    public void saveAsDraft(BlogPost blogPost) {
        blogPost.setDraft(true);
        blogPostDAO.save(blogPost);
    }

    @Override
    public void deletePost(BlogPost blogPost) {
        blogPostDAO.delete(blogPost);
    }

    @Override
    public List<BlogPost> listAllBlogPostByUserAndDraftStatus(User user, boolean draft) {

        return blogPostDAO.findAllBlogPostsByUserAndDraft(user,draft);
    }

    @Override
    public List<BlogPost> listAllBlogPostByUserAndTitleLike(User user, String title)
    {
        return blogPostDAO.findAllBlogPostByUserAndTitleContaining(user, title);
    }

    @Override
    public BlogPost findBlogPostById(long id) {
        return blogPostDAO.findOne(id);
    }


}
