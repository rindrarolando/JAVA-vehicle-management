package com.first.evaluation.impl;

import com.first.evaluation.dao.ArrivalRepository;
import com.first.evaluation.entities.Arrival;
import com.first.evaluation.services.ArrivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArrivalServiceImplements implements ArrivalService {
    @Autowired
    ArrivalRepository repo;


    @Override
    public void addArrival(Arrival arrival) {
        repo.save(arrival);
    }

    @Override
    public int getNextval() {
        return repo.getNextval();
    }
}
