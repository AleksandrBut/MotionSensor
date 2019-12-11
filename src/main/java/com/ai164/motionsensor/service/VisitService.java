package com.ai164.motionsensor.service;

import com.ai164.motionsensor.dto.VisitPerDayResponseItem;
import com.ai164.motionsensor.dto.VisitRequestItem;
import com.ai164.motionsensor.dto.VisitPerHourResponseItem;
import com.ai164.motionsensor.model.Visit;

import java.util.List;

public interface VisitService {
    void prepareDataBaseForTest();

    List<Visit> getAllVisits();

    void deleteAllVisits();

    List<VisitPerHourResponseItem> findVisitsPerHourForDay(int year, int month, int date);

    void saveVisit(VisitRequestItem visitRequestItem);

    List<VisitPerDayResponseItem> findVisitsPerDayForWeekBeforeDate(int year, int month, int day);
}
