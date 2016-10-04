package br.com.transaction.business.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by fernando on 04/10/16.
 */
@Configuration
@EnableTransactionManagement
public class PersistenceConfiguration {

    @Bean("entityManager")
    public LocalContainerEntityManagerFactoryBean entityManager() {

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("br.com.transaction.domain");
        factoryBean.setJpaDialect(new HibernateJpaDialect());

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter() {
            {
                setShowSql(false); // NÃO ALTERAR isso para TRUE, usar o log4j se precisar do log das queries
                determineDatabaseDialectClass(Database.MYSQL);
            }
        };

        factoryBean.setJpaVendorAdapter(vendorAdapter);

        return factoryBean;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://54.208.15.127:3306/paycom");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager().getObject());
        transactionManager.setJpaDialect(new HibernateJpaDialect());
        transactionManager.setNestedTransactionAllowed(true);

        return transactionManager;
    }

}
