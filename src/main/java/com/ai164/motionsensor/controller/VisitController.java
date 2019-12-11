package com.ai164.motionsensor.controller;

import com.ai164.motionsensor.dto.VisitCounterRequestItem;
import com.ai164.motionsensor.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@RestController
public class VisitController {

    @Autowired
    private VisitService visitService;

    /*
     * /day - get visits per hour
     */
    @RequestMapping("/")
    public String event() {
        LocalDateTime time = LocalDateTime.now(ZoneId.of("EET"));

        LocalDateTime localDateTime = LocalDateTime.parse("12/11/2012:24", DateTimeFormatter.ofPattern("dd/mm/yyyy:hh"));

        System.out.println("time.getYear() = " + localDateTime.getYear());
        System.out.println("time.getMonth() = " + localDateTime.getMonthValue());
        System.out.println("time.getDayOfMonth() = " + localDateTime.getDayOfMonth());
        System.out.println("time.getHour() = " + localDateTime.getHour());
        System.out.println("time.getMinute() = " + localDateTime.getMinute());

        visitService.prepareDataBaseForTest();
        return visitService.getAllVisits().toString();
    }

    @RequestMapping("/delete-all")
    public void deleteAllVisits() {
        visitService.deleteAllVisits();
    }

    @PostMapping("/save-visits")
    public void incrementVisitCounter(@RequestBody VisitCounterRequestItem visitCounterRequestItem) {

    }
}
