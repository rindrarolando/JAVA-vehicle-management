package com.first.evaluation.impl;

import com.first.evaluation.dao.VehiclestateRepository;
import com.first.evaluation.services.VehiclestateService;
import com.first.evaluation.views.Vehiclestate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiclestateServiceImplements implements VehiclestateService {
    @Autowired
    VehiclestateRepository repo;

    @Override
    public Vehiclestate getVehicleStates(String number) {
        return repo.getVehicleStates(number);
    }

    @Override
    public List<Vehiclestate> getAllVehicleStates() {
        return repo.getAllVehicleStates();
    }
}
