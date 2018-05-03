package ua.singleton.buyabook.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("application.properties")
@EnableTransactionManagement
public class DataConfig {

    // Used to read settings from application.properties file
    @Autowired
    private Environment env;

    /**
     * Declare the JPA entity manager factory
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan(env.getProperty("buyabook.entity.package"));
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactory.setJpaProperties(hibernateProperties());
        return entityManagerFactory;
    }

    /**
     * DataSource definition for database connection
     */
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("buyabook.datasource.driver"));
        dataSource.setUrl(env.getProperty("buyabook.datasource.url"));
        dataSource.setUsername(env.getProperty("buyabook.datasource.username"));
        dataSource.setPassword(env.getProperty("buyabook.datasource.password"));
        return dataSource;
    }

    // Hibernate properties
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.property.hbm2ddl"));
        properties.setProperty("hibernate.dialect", env.getProperty("hibernate.property.dialect"));
        return properties;
    }

    /**
     * Declare the transaction manager
     */
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
