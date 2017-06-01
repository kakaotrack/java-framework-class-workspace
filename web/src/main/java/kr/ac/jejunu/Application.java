package kr.ac.jejunu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.oxm.castor.CastorMarshaller;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;

@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter{

//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.enableContentNegotiation(new MappingJackson2JsonView());
//        registry.enableContentNegotiation(new MarshallingView(new CastorMarshaller()));
//        registry.jsp().prefix("/WEB-INF/views/");
//
//    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
