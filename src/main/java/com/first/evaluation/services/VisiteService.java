package com.first.evaluation.services;

import com.first.evaluation.entities.Visite;

public interface VisiteService {
    void addVisit(Visite visit);

    Visite getVisitOfVehicle(String numero);
}
