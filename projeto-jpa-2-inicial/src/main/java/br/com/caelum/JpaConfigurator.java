package br.com.caelum;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
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

		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");		
		props.setProperty("hibernate.show_sql", "true");
		
		props.setProperty("hibernate.hbm2ddl.auto", "create-drop");	// validate, update, create ou create-drop.
		/*		
		validate: validar o schema, não faz mudanças no banco de dados.
		update: faz update o schema.
		create: cria o schema, destruindo dados anteriores.
		create-drop: drop o schema quando ao terminar a sessão.
		 */
		
		// Configura o cache de segundo nivel
        props.setProperty("hibernate.cache.use_second_level_cache", "true");
        props.setProperty("hibernate.cache.use_query_cache", "true"); // -> CriteriaQuery -> ProdutoDaogetProdutos()
        
        // Configura o provedor do cache
        // EhCache é um dos providers mais comuns de se trabalhar com Hibernate
        props.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");

        
        // Statistics
        props.setProperty("hibernate.generate_statistics", "true");
        
		entityManagerFactory.setJpaProperties(props);
		return entityManagerFactory;
	}

	// adicionarmos Statistics ao contexto do Spring
	@Bean
	public Statistics statistics(EntityManagerFactory emf) { 
	    return emf.unwrap(SessionFactory.class).getStatistics();
	}	
	
	@Bean
	public JpaTransactionManager getTransactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}
	

}
