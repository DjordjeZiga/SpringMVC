package springmvc.java.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by ziga on 11/7/16.
 */
public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(WebConfig.class);

        container.addListener(new ContextLoaderListener(rootContext));

        DelegatingFilterProxy filter=new DelegatingFilterProxy("springSecurityFilterChain");

        DispatcherServlet dispatcherServlet = new DispatcherServlet(rootContext);
        ServletRegistration.Dynamic registration= container.addServlet("dispatcherServlet", dispatcherServlet);

        container.addFilter("springSecurityFilterChain", filter).addMappingForUrlPatterns(null, false, "/*");

        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
