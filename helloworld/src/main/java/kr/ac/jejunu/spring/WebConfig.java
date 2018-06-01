package kr.ac.jejunu.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;
import org.springframework.web.util.UrlPathHelper;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "kr.ac.jejunu")
@EnableJpaRepositories(basePackages = "kr.ac.jejunu.spring", entityManagerFactoryRef="entityManagerFactoryBean")
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("kr.ac.jejunu.hello");

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(jpaVendorAdapter);
        em.setJpaProperties(properties);
        return em;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jeju?characterEncoding=utf-8");
        dataSource.setUsername("jeju");
        dataSource.setPassword("jejupw");

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        if(configurer.getUrlPathHelper() == null) {
            configurer.setUrlPathHelper(new UrlPathHelper());
        }
        configurer.getUrlPathHelper().setRemoveSemicolonContent(false);
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.mediaType("js", MediaType.APPLICATION_JSON);
        configurer.mediaType("x", MediaType.APPLICATION_XML);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HelloInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("/WEB-INF/static/");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
        registry.enableContentNegotiation(new MappingJackson2JsonView());
        registry.enableContentNegotiation(new MappingJackson2XmlView());
    }
}
