package com.ai164.motionsensor.controller;

import com.ai164.motionsensor.dto.VisitRequestItem;
import com.ai164.motionsensor.dto.VisitResponseItem;
import com.ai164.motionsensor.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisitController {

    @Autowired
    private VisitService visitService;

    @RequestMapping(value = "/day-stat", method = RequestMethod.GET)
    public List<VisitResponseItem> findVisitsPerHourForDay(@RequestParam int year,
                                                           @RequestParam int month,
                                                           @RequestParam int day) {
        return visitService.findVisitsPerHourForDay(year, month, day);
    }

    @RequestMapping("/delete-all")
    public void deleteAllVisits() {
        visitService.deleteAllVisits();
    }

    @RequestMapping(value = "/save-visit", method = RequestMethod.POST)
    public void saveVisit(@RequestBody VisitRequestItem visitRequestItem) {
        visitService.saveVisit(visitRequestItem);
    }

    @RequestMapping("/test")
    public void addTestData() {
        visitService.prepareDataBaseForTest();
    }
}
