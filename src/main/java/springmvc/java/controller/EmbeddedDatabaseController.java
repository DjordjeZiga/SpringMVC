package springmvc.java.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvc.java.domain.DataSource;

import java.util.List;
import java.util.Map;

/**
 * Created by ziga on 11/26/16.
 */

@Controller
public class EmbeddedDatabaseController  {

    public static final Logger LOGGER = LoggerFactory.getLogger(EmbeddedDatabaseController.class);

    @Autowired
    @Qualifier("embedded")
    private javax.sql.DataSource embedded;

    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/displayUsers")
    public void displayUsers(){
        jdbcTemplate= new JdbcTemplate(embedded);

        List<Map<String, Object>> users = jdbcTemplate.queryForList("SELECT  * FROM  USER");

        for (Map<String,Object> user : users){
            LOGGER.debug("username:" + user.get("username"));
        }
    }
}

