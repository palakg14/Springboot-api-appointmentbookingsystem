package com.example.demo;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.example.demo", "com.example.demo"}, entityManagerFactoryRef = "mykaarmaEntityManagerFactory", transactionManagerRef = "mykaarmaTransactionManager")
public class AppointmentdbConfig {

    /**
     * Read DB Connections properties from yml
     *
     * @return DataSourceProperties
     */
    @Bean(name = "mykaarmaDataSourceProperties")
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties mykaarmaDataSourceProperties() {

        return new DataSourceProperties();
    }

    /**
     * Create datasource using properties from above properties
     *
     * @return ConfigurationProperties
     */
    @Bean(name = "mykaarmaDataSource")
    @ConfigurationProperties("spring.datasource")
    public DataSource mykaarmaDataSource() {

        return mykaarmaDataSourceProperties().initializeDataSourceBuilder().build();
    }


    /**
     * Create EntityManager using above datasource
     *
     * @param builder            EntityManagerFactoryBuilder
     * @param mykaarmadataSource DataSource
     * @return LocalContainerEntityManagerFactoryBean
     */
    @Bean(name = "mykaarmaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mykaarmaEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("mykaarmaDataSource") DataSource mykaarmadataSource) {
        return builder.dataSource(mykaarmadataSource).packages("com.example.demo", "com.example.demo").build();

    }

    /**
     * Create JPA TransactionManager from entityManager bean create above.
     *
     * @param mykaarmaEntityManagerFactory EntityManagerFactory
     * @return PlatformTransactionManager
     */
    @Bean(name = "mykaarmaTransactionManager")
    public PlatformTransactionManager mykaarmaTransactionManager(@Qualifier("mykaarmaEntityManagerFactory") EntityManagerFactory mykaarmaEntityManagerFactory) {
        return new JpaTransactionManager(mykaarmaEntityManagerFactory);
    }

}