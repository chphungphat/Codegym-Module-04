package com.codegym;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GotchaGameAopApplication {

    @Bean
    private ModelMapper modelMapper;

    public static void main(String[] args) {
        SpringApplication.run(GotchaGameAopApplication.class, args);
    }

}
