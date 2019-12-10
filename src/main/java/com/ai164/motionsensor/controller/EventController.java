package com.ai164.motionsensor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class EventController {

    @RequestMapping("/")
    public void event() {
        LocalDateTime time = LocalDateTime.now();
        System.out.println("time.getYear() = " + time.getYear());
        System.out.println("time.getMonth() = " + time.getMonthValue());
        System.out.println("time.getDayOfMonth() = " + time.getDayOfMonth());
        System.out.println("time.getHour() = " + time.getHour());
        System.out.println("time.getMinute() = " + time.getMinute());
    }
}
