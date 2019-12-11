package com.ai164.motionsensor.repository;

import com.ai164.motionsensor.model.Visit;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface VisitRepository extends CrudRepository<Visit, Long> {
    List<Visit> getVisitsByTime_Date(LocalDate time_date);
}
