package com.codegym.use_di;

import com.codegym.use_di.controller.DIAboutController;
import com.codegym.use_di.controller.DIContactController;
import com.codegym.use_di.controller.DIHomeController;
import com.codegym.use_di.service.DIEmailService;
import com.codegym.use_di.service.DIFacebookService;
import com.codegym.use_di.service.DIMessageService;
import com.codegym.use_di.service.DISmsService;

public class DIApplication {

    public static void main(String[] args) {

        //We saw: Controller and Service do not dependent on each others
        //If we have edit something at Controller or Service will not effect each others
        //Just edit at MessageService will be okay => less dependency
        DIMessageService diEmailService = new DIEmailService();
        DIMessageService diFacebookService = new DIFacebookService();
        DIMessageService diSmsService = new DISmsService();

//        DIHomeController diHomeController = new DIHomeController(diEmailService);
//        DIHomeController diHomeController = new DIHomeController(diFacebookService);//dùng cách gửi khác
        DIHomeController diHomeController = new DIHomeController(diSmsService);//dùng cách gửi khác
        DIAboutController diAboutController = new DIAboutController(diFacebookService);
        DIContactController diContactController = new DIContactController(diEmailService);

        diHomeController.send();//sms sending
        diAboutController.send();
        diContactController.send();
    }
}
