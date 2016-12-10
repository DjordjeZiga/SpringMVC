package springmvc.java.controller;

import org.jboss.logging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;
import springmvc.java.service.BlogPostService;
import springmvc.java.service.UserService;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

/**
 * Created by ziga on 11/29/16.
 */

@Controller
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/saveBlogPost", method = RequestMethod.POST)
    public ModelAndView saveBlogPost(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content,
            @RequestParam(value = "draft", required = false) boolean draft, Locale locale,Principal principal
            ){

        BlogPost blogPost=new BlogPost();
        blogPost.setTitle(title);
        blogPost.setContent(content);


        blogPost.setUser(userService.findUserWithBlogPostByUsername(principal.getName()));

        if(draft==true){
            blogPostService.saveAsDraft(blogPost);
        }else{
            blogPostService.savePost(blogPost);
        }

        return new ModelAndView("newblogpost","message",messageSource.getMessage("blogpost.save", null, locale ));
    }
    @RequestMapping(value = "/blogposts", method = RequestMethod.GET)
    public ModelAndView blogPosts(Principal principal){

        User user= userService.findUserWithBlogPostByUsername(principal.getName());
        List<BlogPost> blogPosts=user.getBlogPosts();
        return new ModelAndView("blogposts","blogposts",blogPosts);
    }

    @RequestMapping(value = "/draftblogposts", method = RequestMethod.GET)
    public ModelAndView draftBlogPosts(Principal principal){
        User user= userService.findUserWithBlogPostByUsername(principal.getName());

        List<BlogPost> draftBlogPost=blogPostService.listAllBlogPostByUserAndDraftStatus(user,true);

        return new ModelAndView("blogposts","blogposts",draftBlogPost);
    }

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/searchByTitle", method = RequestMethod.POST)
    public ModelAndView searchByTitle(@RequestParam(value = "title") String title,Principal principal){
        User user= userService.findUserWithBlogPostByUsername(principal.getName());

        List<BlogPost> blogPosts=blogPostService.listAllBlogPostByUserAndTitleLike(user,title);

        return new ModelAndView("blogposts","blogposts",blogPosts);
    }

    @RequestMapping(value = "/getBlogPostById/{id}", method = RequestMethod.GET)
    @ResponseStatus(code= HttpStatus.OK)
    public @ResponseBody BlogPost getBlogPostById(@PathVariable(value = "id") long idBlogPost){

        return blogPostService.findBlogPostById(idBlogPost);
    }

}