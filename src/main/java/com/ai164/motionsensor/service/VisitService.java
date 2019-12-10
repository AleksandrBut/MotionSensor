package com.ai164.motionsensor.service;

import com.ai164.motionsensor.model.Visit;

import java.util.List;

public interface VisitService {
    void prepareDataBaseForTest();

    List<Visit> getAllVisits();

    void deleteAllVisits();
}
