package com.ai164.motionsensor.service;

import com.ai164.motionsensor.dto.VisitPerHourRequestItem;
import com.ai164.motionsensor.dto.VisitPerHourResponseItem;
import com.ai164.motionsensor.model.Visit;
import com.ai164.motionsensor.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitRepository visitRepository;

    @Override
    public void prepareDataBaseForTest() {

    }

    @Override
    public List<Visit> getAllVisits() {
        return (List<Visit>) visitRepository.findAll();
    }

    @Override
    public void deleteAllVisits() {
        visitRepository.deleteAll();
    }

    @Override
    public List<VisitPerHourResponseItem> findVisitsPerHourForDay(int year, int month, int day) {
        List<Visit> visits = visitRepository.findVisitsByYearAndMonthAndDay(year, month, day);
        List<VisitPerHourResponseItem> visitPerHourResponseItems = new ArrayList<>();

        for (Visit visit : visits) {
            visitPerHourResponseItems.add(VisitPerHourResponseItem.newBuilder()
                    .setYear(visit.getYear())
                    .setMonth(visit.getMonth())
                    .setDay(visit.getDay())
                    .setHour(visit.getHour())
                    .setVisitCounter(visit.getVisitCounter())
                    .build());
        }

        return visitPerHourResponseItems;
    }

    @Override
    public void saveVisit(VisitPerHourRequestItem visitPerHourRequestItem) {
        Visit visit = visitRepository.findVisitByYearAndMonthAndDayAndHour(visitPerHourRequestItem.getYear(),
                visitPerHourRequestItem.getMonth(),
                visitPerHourRequestItem.getDay(),
                visitPerHourRequestItem.getHour());

        if (visit == null) {
            visitRepository.save(Visit.newBuilder()
                    .setYear(visitPerHourRequestItem.getYear())
                    .setMonth(visitPerHourRequestItem.getMonth())
                    .setDay(visitPerHourRequestItem.getDay())
                    .setHour(visitPerHourRequestItem.getHour())
                    .setVisitCounter(visitPerHourRequestItem.getVisitCounter())
                    .build());
        } else {
            visit.setVisitCounter(visitPerHourRequestItem.getVisitCounter());
            visitRepository.save(visit);
        }
    }
}
