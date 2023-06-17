package com.codegym.beans.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "fullstack")
//    @Bean
    public Developer fullstack() {
        Developer developer = new Developer();
        developer.setId(3);
        developer.setName("chung@gmail.com");
        developer.setMajor("FullStack");
        return developer;
    }

    @Bean
    public Developer developer() {
        Developer developer = new Developer();
        developer.setId(4);
        developer.setName("huy@gmail.com");
        developer.setMajor("FullStack");
        return developer;
    }
}
