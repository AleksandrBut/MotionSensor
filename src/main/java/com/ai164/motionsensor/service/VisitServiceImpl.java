package com.ai164.motionsensor.service;

import com.ai164.motionsensor.dto.VisitPerDayResponseItem;
import com.ai164.motionsensor.dto.VisitPerHourResponseItem;
import com.ai164.motionsensor.dto.VisitRequestItem;
import com.ai164.motionsensor.model.Visit;
import com.ai164.motionsensor.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
        List<VisitPerHourResponseItem> visitPerHourResponseItems = new ArrayList<>(24);

        int hoursInDay = 24;

        for (int i = 0; i < hoursInDay; i++) {
            visitPerHourResponseItems.add(VisitPerHourResponseItem.newBuilder()
                    .setYear(year)
                    .setMonth(month)
                    .setDay(day)
                    .setHour(i)
                    .build());
        }

        for (Visit visit : visits) {
            VisitPerHourResponseItem responseItem = visitPerHourResponseItems.get(visit.getHour());
            responseItem.setVisitCounter(visit.getVisitCounter());
            visitPerHourResponseItems.set(visit.getHour(), responseItem);
        }

        return visitPerHourResponseItems;
    }

    @Override
    public void saveVisit(VisitRequestItem visitRequestItem) {
        Visit visit = visitRepository.findVisitByYearAndMonthAndDayAndHour(visitRequestItem.getYear(),
                visitRequestItem.getMonth(),
                visitRequestItem.getDay(),
                visitRequestItem.getHour());

        if (visit == null) {
            visitRepository.save(Visit.newBuilder()
                    .setYear(visitRequestItem.getYear())
                    .setMonth(visitRequestItem.getMonth())
                    .setDay(visitRequestItem.getDay())
                    .setHour(visitRequestItem.getHour())
                    .setVisitCounter(visitRequestItem.getVisitCounter())
                    .build());
        } else {
            visit.setVisitCounter(visitRequestItem.getVisitCounter());
            visitRepository.save(visit);
        }
    }

    @Override
    public List<VisitPerDayResponseItem> findVisitsPerDayForWeekBeforeDate(int year, int month, int day) {
        LocalDateTime time = LocalDateTime.of(year, month, day, 0, 0);
        int daysInWeek = 7;

        time = time.minus(daysInWeek, ChronoUnit.DAYS);
        List<VisitPerDayResponseItem> visitPerDayResponseItems = new ArrayList<>(daysInWeek);

        for (int i = 0; i < daysInWeek; i++) {
            time = time.plus(1, ChronoUnit.DAYS);

            List<Visit> visits = visitRepository.findVisitsByYearAndMonthAndDay(time.getYear(),
                    time.getMonthValue(),
                    time.getDayOfMonth());

            int numberOfVisitsPerDay = 0;

            for (Visit visit : visits) {
                numberOfVisitsPerDay += visit.getVisitCounter();
            }

            visitPerDayResponseItems.add(VisitPerDayResponseItem.newBuilder()
                    .setYear(time.getYear())
                    .setMonth(time.getMonthValue())
                    .setDay(time.getDayOfMonth())
                    .setVisitCounter(numberOfVisitsPerDay)
                    .build());
        }

        return visitPerDayResponseItems;
    }
}
