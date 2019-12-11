package com.ai164.motionsensor.controller;

import com.ai164.motionsensor.dto.VisitCounterRequestItem;
import com.ai164.motionsensor.model.Visit;
import com.ai164.motionsensor.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisitController {

    @Autowired
    private VisitService visitService;

    @RequestMapping(value = "/day",
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.GET)
    public List<Visit> getVisitsPerHourForDay(@RequestParam String dateTime) {
        return visitService.getVisitsPerHourForDay(dateTime);
    }

    @RequestMapping("/delete-all")
    public void deleteAllVisits() {
        visitService.deleteAllVisits();
    }

    @RequestMapping("/save-visits")
    public void incrementVisitCounter(@RequestBody VisitCounterRequestItem visitCounterRequestItem) {

    }

    @RequestMapping("/test")
    public void addTestData() {
        visitService.prepareDataBaseForTest();
    }
}
