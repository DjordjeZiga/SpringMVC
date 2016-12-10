package springmvc.java.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springmvc.java.service.BlogPostService;
import springmvc.java.service.EmailService;

/**
 * Created by ziga on 11/6/16.
 */
public class EmailServiceImpl implements EmailService {

    public static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Override
    public void sendEmail() {
        LOGGER.debug("EmailServiceImpl: sendEmail is called");
    }
}
