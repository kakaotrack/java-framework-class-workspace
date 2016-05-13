package kr.ac.jejunu.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.castor.CastorMarshaller;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;
import org.springframework.web.util.UrlPathHelper;

/**
 * Created by hyh0408 on 2016. 5. 13..
 */
@Configuration
@ComponentScan(basePackages = "kr.ac.jejunu.spring")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter{
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        if (configurer.getUrlPathHelper() == null) {
            UrlPathHelper urlPathHelper = new UrlPathHelper();
            urlPathHelper.setRemoveSemicolonContent(false);
            configurer.setUrlPathHelper(urlPathHelper);
        } else {
            configurer.getUrlPathHelper().setRemoveSemicolonContent(false);
        }
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HelloInterceptor()).addPathPatterns("/**/*").excludePathPatterns("/login");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.enableContentNegotiation(new MappingJackson2JsonView());
        registry.enableContentNegotiation(new MarshallingView(new CastorMarshaller()));
        registry.jsp().prefix("/WEB-INF/views/");
    }


}
