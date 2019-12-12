package com.ai164.motionsensor.repository;

import com.ai164.motionsensor.model.Visit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VisitRepository extends CrudRepository<Visit, Long> {
    Visit findVisitByYearAndMonthAndDayAndHour(int year, int month, int day, int hour);

    List<Visit> findVisitsByYearAndMonthAndDay(int year, int month, int day);

    void deleteByYearAndMonthAndDayAndHour(int year, int month, int day, int hour);
}
