package com.ai164.motionsensor.service;

import com.ai164.motionsensor.dto.VisitRequestItem;
import com.ai164.motionsensor.dto.VisitResponseItem;
import com.ai164.motionsensor.model.Visit;
import com.ai164.motionsensor.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitRepository visitRepository;

    private static String DATE_TIME_PATTERN = "yyyy-MM-dd_HH";
    private static String DAY_PATTERN = "yyyy-MM-dd";

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
    public List<VisitResponseItem> findVisitsPerHourForDay(String date) {
        LocalDateTime time = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(DAY_PATTERN));
        List<Visit> visits = visitRepository.findVisitsByYearAndMonthAndDay(time.getYear(), time.getMonthValue(), time.getDayOfMonth());

        List<VisitResponseItem> visitResponseItems = new ArrayList<>();

        for (Visit visit : visits) {
            visitResponseItems.add(VisitResponseItem.newBuilder()
                    .setYear(visit.getYear())
                    .setMonth(visit.getMonth())
                    .setDay(visit.getDay())
                    .setHour(visit.getHour())
                    .setVisitCounter(visit.getVisitCounter())
                    .build());
        }

        return visitResponseItems;
    }

    @Override
    public void saveVisit(VisitRequestItem visitRequestItem) {
        LocalDateTime time = LocalDateTime.parse(visitRequestItem.getDateTime(), DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
        Visit visit = visitRepository.findVisitByYearAndMonthAndDayAndHour(time.getYear(),
                time.getMonthValue(),
                time.getDayOfMonth(),
                time.getHour());

        if (visit == null) {
            visitRepository.save(Visit.newBuilder()
                    .setYear(time.getYear())
                    .setMonth(time.getMonthValue())
                    .setDay(time.getDayOfMonth())
                    .setHour(time.getHour())
                    .setVisitCounter(visitRequestItem.getVisitCounter())
                    .build());
        } else {
            visit.setVisitCounter(visitRequestItem.getVisitCounter());
            visitRepository.save(visit);
        }
    }
}
