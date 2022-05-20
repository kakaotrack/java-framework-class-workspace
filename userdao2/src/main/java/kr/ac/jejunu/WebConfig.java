package kr.ac.jejunu;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;

@Configuration
@EnableWebMvc
@ComponentScan("kr.ac.jejunu")
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("/WEB-INF/static/");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp().suffix(".jsp").prefix("/WEB-INF/views/");
        registry.enableContentNegotiation(new MappingJackson2XmlView());
        registry.enableContentNegotiation(new MappingJackson2JsonView());
    }
}
