package com.first.evaluation.services;

import com.first.evaluation.entities.Departure;

import java.util.List;

public interface DepartureService {

    public void addDeparture(Departure tra);

    public int getNextval();

    public List<Departure> getAllDepartures(int id);

    public Departure getDepartureById(int id);
}
