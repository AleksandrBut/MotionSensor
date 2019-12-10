package com.ai164.motionsensor.service;

import com.ai164.motionsensor.model.Visit;
import com.ai164.motionsensor.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitRepository visitRepository;

    @Override
    public void prepareDataBaseForTest() {
        visitRepository.save(new Visit(2019, 12, 10, 20));
        visitRepository.save(new Visit(2019, 11, 7, 3));
        visitRepository.save(new Visit(2019, 10, 5, 24));
    }

    @Override
    public List<Visit> getAllVisits() {
        return (List<Visit>) visitRepository.findAll();
    }

    @Override
    public void deleteAllVisits() {
        visitRepository.deleteAll();
    }
}
