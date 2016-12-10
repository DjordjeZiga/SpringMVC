package springmvc.java.config;

import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springmvc.java.domain.User;
import springmvc.java.service.BlogPostService;
import springmvc.java.service.UserService;
import springmvc.java.service.impl.BlogPostServiceImpl;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by ziga on 11/24/16.
 */
@EnableJpaRepositories(basePackages = {"springmvc.java.dao"})
@EnableTransactionManagement
@Configuration
public class ApplicationContext {

    @Autowired
    private org.springframework.core.env.Environment environment;

    @Bean
    public DataSource dataSource(){

        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.driverClass"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));

        return dataSource;
    }

    @Bean
    public BlogPostService blogPostService(){
        return new BlogPostServiceImpl();
    }

    @Bean
    @Qualifier("embedded")
    public DataSource dataSourceEmbedded(){
        EmbeddedDatabaseBuilder builder= new EmbeddedDatabaseBuilder();
        EmbeddedDatabase embeddedDatabase= builder.setType(EmbeddedDatabaseType.HSQL).addScript("dbschema.sql").addScript("test-data.sql").build();
        return embeddedDatabase;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager jpaTransactionManager= new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);

        DatabasePopulatorUtils.execute(databasePopulator(), dataSource());

        return jpaTransactionManager;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        jpaVendorAdapter.setShowSql(true);

        return jpaVendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());

        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
        entityManagerFactory.setPackagesToScan("springmvc.java.domain");

        Properties jpaProperties= new Properties();
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");

        entityManagerFactory.setJpaProperties(jpaProperties);

        return entityManagerFactory;
    }

    private DatabasePopulator databasePopulator() {

        ResourceDatabasePopulator databasePopulator= new ResourceDatabasePopulator();
        databasePopulator.setContinueOnError(true);
        databasePopulator.addScript(new ClassPathResource("test-data.sql"));
        return databasePopulator;
    }

}
