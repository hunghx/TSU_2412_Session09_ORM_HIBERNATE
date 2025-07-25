package ra.orm.config;

import org.springframework.context.annotation.Bean;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;
@Configuration
@EnableTransactionManagement // Bật tính năng quản lý giao dịch trong Spring
public class HibernateConfig {
    @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource());
        sessionBuilder.scanPackages("ra.orm.entity"); // package containing your entity classes
        sessionBuilder.addProperties(hibernateProperties());
        return sessionBuilder.buildSessionFactory();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC driver
        dataSource.setUrl("jdbc:mysql://localhost:3306/orm_hibernate?createDatabaseIfNotExist=true");// replace with your database URL
        dataSource.setUsername("root");// replace with your database username
        dataSource.setPassword("123456$"); // replace with your database password
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect"); // MySQL dialect
        properties.put("hibernate.hbm2ddl.auto", "update"); // Automatically update the database schema
        properties.put("hibernate.show_sql", "true");  // Show SQL queries in the console
        properties.put("hibernate.format_sql", "true"); // Format SQL queries for better readability
        return properties;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager txManager = new HibernateTransactionManager();

        txManager.setSessionFactory(sessionFactory());
        return txManager;
    }
}
