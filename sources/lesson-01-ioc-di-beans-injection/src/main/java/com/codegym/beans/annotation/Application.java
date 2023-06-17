package com.codegym.beans.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Developer fs1 = (Developer) context.getBean("developer");
        Developer fs2 = (Developer) context.getBean("fullstack");
        System.out.println(fs1);
        System.out.println(fs2);

        context.close();
    }
}
