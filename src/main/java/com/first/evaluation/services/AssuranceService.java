package com.first.evaluation.services;

import com.first.evaluation.entities.Assurance;

public interface AssuranceService {
    void addAssurance(Assurance assurance);
    Assurance getAssuranceOfVehicle(String numero);
}
