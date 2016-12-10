package springmvc.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import springmvc.java.domain.BlogPost;
import springmvc.java.service.BlogPostService;
import springmvc.java.service.ServiceManager;

/**
 * Created by ziga on 11/6/16.
 */
public class ServiceManagerImpl implements ServiceManager{

    @Autowired
    @Qualifier("MediumBlogPostService")
    private BlogPostService blogPostService;

    @Override
    public void sendBlogPost(BlogPost blogPost) {
        blogPostService.savePost(blogPost);
    }
}

