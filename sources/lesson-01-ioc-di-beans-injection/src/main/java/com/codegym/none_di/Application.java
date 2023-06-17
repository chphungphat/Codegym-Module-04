package com.codegym.none_di;

import com.codegym.none_di.controller.AboutController;
import com.codegym.none_di.controller.ContactController;
import com.codegym.none_di.controller.HomeController;

public class Application {

    public static void main(String[] args) {

        HomeController homeController = new HomeController();
        AboutController aboutController = new AboutController();

        //Main -> ContactController -> FacebookService
        // => too much dependency here
        ContactController contactController = new ContactController();

        homeController.send();//facebook sending
        aboutController.send();
        contactController.send();
    }
}
