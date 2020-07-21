package com.spring.orm.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spring.orm.dao.ProductDAO;
import com.spring.orm.dao.ProductDAOImpl;
import com.spring.orm.model.Product;

/**
 * The @EnableTransactionManager annotation enables Spring’s annotation-driven
 * transaction management capability.
 * 
 * @author Administrator
 *
 */
@Configuration
@ComponentScan("com.spring.orm")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("1729");

		return dataSource;
	}

	/**
	 * NOTE: For Java-based configuration, Spring provides the
	 * LocalSessionFactoryBuilder that facilitates the creation of Hibernate’s
	 * SessionFactory. For XML configuration, a LocalSessionFactoryBean is used
	 * instead.
	 * 
	 * @param dataSource
	 * @return
	 */
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(
				dataSource);

		sessionBuilder.addAnnotatedClasses(Product.class);

		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}

	@Autowired
	@Bean(name = "productDAO")
	public ProductDAO getProductDAO(SessionFactory sessionFactory) {
		return new ProductDAOImpl(sessionFactory);
	}
}