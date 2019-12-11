package com.ai164.motionsensor.repository;

import com.ai164.motionsensor.model.Visit;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
