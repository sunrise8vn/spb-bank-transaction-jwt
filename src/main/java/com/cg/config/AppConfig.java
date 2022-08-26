package com.cg.config;


//import com.cg.model.AuditorAwareImpl;
//import com.cg.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.domain.AuditorAware;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
//@Import(SwaggerConfig.class)
//@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AppConfig {

//    @Bean
//    public AuditorAware<User> auditorProvider() {
//        return new AuditorAwareImpl();
//    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:3000", "http://localhost:3300")
                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
            }
        };
    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/api/**")
////                .allowedOrigins("https://mysterious-mountain-94405.herokuapp.com")
//                .allowedOrigins("*")
//                .allowedMethods("GET", "POST", "DELETE")
//                .allowedHeaders("*")
//                .allowCredentials(false)
//                .maxAge(3600);
//    }

}
