package com.ai164.motionsensor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.LocalDateTime;

@RestController
public class EventController {

    @Autowired
    private DataSource dataSource;

    @RequestMapping("/")
    public void event() throws SQLException {
        LocalDateTime time = LocalDateTime.now();
        System.out.println("time.getYear() = " + time.getYear());
        System.out.println("time.getMonth() = " + time.getMonthValue());
        System.out.println("time.getDayOfMonth() = " + time.getDayOfMonth());
        System.out.println("time.getHour() = " + time.getHour());
        System.out.println("time.getMinute() = " + time.getMinute());
        System.out.println(dataSource.getConnection().getSchema());
    }
}
