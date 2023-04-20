package com.first.evaluation.impl;

import com.first.evaluation.dao.VisiteRepository;
import com.first.evaluation.entities.Visite;
import com.first.evaluation.services.VisiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisiteServiceImplements implements VisiteService {
    @Autowired
    VisiteRepository repo;

    @Override
    public void addVisit(Visite visit) {
        repo.save(visit);
    }

    @Override
    public Visite getVisitOfVehicle(String numero) {
        return repo.getVisitOfVehicle(numero);
    }
}
