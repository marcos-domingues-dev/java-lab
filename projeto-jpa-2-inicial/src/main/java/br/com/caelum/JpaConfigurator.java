package br.com.caelum;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
public class JpaConfigurator {

	// Esse atributo define o método (close) do Pool que o Spring chama quando o Tomcat é desligado.
	@Bean(destroyMethod = "close")
	public DataSource getDataSource() throws PropertyVetoException {
	    ComboPooledDataSource dataSource = new ComboPooledDataSource();

	    dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");    
	    dataSource.setUser("root");
	    dataSource.setPassword("");
	    dataSource.setJdbcUrl("jdbc:mysql://localhost/projeto_jpa?useSSL=false&serverTimezone=UTC");
	    
	    dataSource.setInitialPoolSize(3);
	    
	    dataSource.setMinPoolSize(3);
	    dataSource.setMaxPoolSize(5);
	    dataSource.setNumHelperThreads(5);

	    return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactory.setPackagesToScan("br.com.caelum");
		entityManagerFactory.setDataSource(dataSource);

		entityManagerFactory
				.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		Properties props = new Properties();
		//props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");		
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "create-drop");

		entityManagerFactory.setJpaProperties(props);
		return entityManagerFactory;
	}

	@Bean
	public JpaTransactionManager getTransactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

}
