package com.ai164.motionsensor.repository;

import com.ai164.motionsensor.model.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface VisitRepository extends CrudRepository<Visit, Long> {
    Visit findVisitByYearAndMonthAndDayAndHour(int year, int month, int day, int hour);

    List<Visit> findVisitsByYearAndMonthAndDay(int year, int month, int day);

    void deleteByYearAndMonthAndDayAndHour(int year, int month, int day, int hour);
}
