package com.ai164.motionsensor.service;

import com.ai164.motionsensor.model.Visit;
import com.ai164.motionsensor.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitRepository visitRepository;

    private static String DATE_PATTERN = "yyyy/MM/dd HH";

    @Override
    public void prepareDataBaseForTest() {
        visitRepository.save(new Visit(LocalDateTime.now(), 4));
        visitRepository.save(new Visit(LocalDateTime.now(ZoneId.of("EET")), 15));
        visitRepository.save(new Visit(LocalDateTime.now(ZoneId.of("EST")), 235));
        visitRepository.save(new Visit(LocalDateTime.now(), 15));
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
    public List<Visit> getVisitsPerHourForDay(String dateTime) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(DATE_PATTERN));
        return visitRepository.getVisitsByTime_Date(localDateTime.toLocalDate());
    }
}
