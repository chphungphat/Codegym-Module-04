package com.codegym.injection.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("constructor-injection.xml");

        TextEditor textEditor = (TextEditor) context.getBean("textEditor");
        textEditor.spellCheck();

        HieuTiger hieuTiger = (HieuTiger) context.getBean("hieuTiger");
        System.out.println(hieuTiger);
        hieuTiger.sayHello();

        ((ClassPathXmlApplicationContext) context).close();
    }
}
