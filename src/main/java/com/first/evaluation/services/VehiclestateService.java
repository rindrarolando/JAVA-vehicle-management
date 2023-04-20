package com.first.evaluation.services;

import com.first.evaluation.views.Vehiclestate;

import java.util.List;

public interface VehiclestateService {
    Vehiclestate getVehicleStates(String number);

    List<Vehiclestate> getAllVehicleStates();
}
