package com.ai164.motionsensor.controller;

import com.ai164.motionsensor.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class EventController {

    @Autowired
    private VisitService visitService;

    @RequestMapping("/")
    public String event() {
        LocalDateTime time = LocalDateTime.now();
        System.out.println("time.getYear() = " + time.getYear());
        System.out.println("time.getMonth() = " + time.getMonthValue());
        System.out.println("time.getDayOfMonth() = " + time.getDayOfMonth());
        System.out.println("time.getHour() = " + time.getHour());
        System.out.println("time.getMinute() = " + time.getMinute());

        visitService.prepareDataBaseForTest();
        return visitService.getAllVisits().toString();
    }
}
