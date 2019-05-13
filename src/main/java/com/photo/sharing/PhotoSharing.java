package com.photo.sharing;

import com.photo.sharing.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Created by AmitAgarwal on 5/2/19.
 */
@SpringBootApplication
public class PhotoSharing {


    @Bean
    public FilterRegistrationBean filterRegistrationBean (){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new JwtFilter());
        filterRegistrationBean.addUrlPatterns("/rest/*");

        return filterRegistrationBean;
    }

    public static void main(String [] args){
        SpringApplication.run(PhotoSharing.class);
    }

}
