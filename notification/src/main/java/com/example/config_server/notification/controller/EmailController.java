package com.example.config_server.notification.controller;

import com.example.config_server.notification.dto.NotificationData;
import com.example.config_server.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification/email")
public class EmailController {

    @Autowired
    NotificationService notificationService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    void notify(@RequestBody NotificationData data) {
        notificationService.notify(data);
    }

}
