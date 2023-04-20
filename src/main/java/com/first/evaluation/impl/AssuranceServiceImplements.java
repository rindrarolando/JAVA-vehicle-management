package com.first.evaluation.impl;

import com.first.evaluation.dao.AssuranceRepository;
import com.first.evaluation.entities.Assurance;
import com.first.evaluation.services.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssuranceServiceImplements implements AssuranceService {
    @Autowired
    AssuranceRepository repo;

    @Override
    public void addAssurance(Assurance assurance) {
        repo.save(assurance);
    }

    @Override
    public Assurance getAssuranceOfVehicle(String numero) {
        return repo.getAssuranceOfVehicle(numero);
    }
}
