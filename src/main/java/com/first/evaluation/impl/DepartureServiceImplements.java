package com.first.evaluation.impl;

import com.first.evaluation.dao.DepartureRepository;
import com.first.evaluation.entities.Departure;
import com.first.evaluation.services.DepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartureServiceImplements implements DepartureService {
    @Autowired
    DepartureRepository repo;

    @Override
    public void addDeparture(Departure dep) {
        repo.save(dep);
    }

    @Override
    public int getNextval() {
        return repo.getNextVal();
    }

    @Override
    public List<Departure> getAllDepartures(int id) {
        return repo.getDeparturesByIdOfDriver(id);
    }

    @Override
    public Departure getDepartureById(int id) {
        return repo.getById(id);
    }
}
