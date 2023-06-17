package com.codegym.injection.setter;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application2 {

    public static void main(String[] args) {
        BeanFactory context = new ClassPathXmlApplicationContext("setter-injection.xml");

        Tran tranStudent = (Tran) context.getBean("tran");
        System.out.println(tranStudent);

        ((ClassPathXmlApplicationContext) context).close();
    }
}
