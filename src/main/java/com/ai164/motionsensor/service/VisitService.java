package com.ai164.motionsensor.service;

import com.ai164.motionsensor.dto.VisitPerHourRequestItem;
import com.ai164.motionsensor.dto.VisitPerHourResponseItem;
import com.ai164.motionsensor.model.Visit;

import java.util.List;

public interface VisitService {
    void prepareDataBaseForTest();

    List<Visit> getAllVisits();

    void deleteAllVisits();

    List<VisitPerHourResponseItem> findVisitsPerHourForDay(int year, int month, int date);

    void saveVisit(VisitPerHourRequestItem visitPerHourRequestItem);
}
