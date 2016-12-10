package springmvc.java.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by ziga on 11/26/16.
 */

@Controller
public class DatabaseController {

    public static final Logger LOGGER = LoggerFactory.getLogger(DatabaseController.class);

    @Autowired
    private javax.sql.DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/displayUsersMySql")
    public void displayUsers(){
        jdbcTemplate= new JdbcTemplate(dataSource);

        List<Map<String, Object>> users = jdbcTemplate.queryForList("SELECT  * FROM  user");

        for (Map<String,Object> user : users){
            LOGGER.debug("MySql username:" + user.get("username"));
        }
    }
}

