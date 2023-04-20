package com.first.evaluation.services;

import com.first.evaluation.entities.Arrival;

public interface ArrivalService {

    public void addArrival(Arrival arrival);

    public int getNextval();
}
