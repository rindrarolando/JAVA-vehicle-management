package com.first.evaluation.impl;

import com.first.evaluation.dao.VehicleRepository;
import com.first.evaluation.entities.Vehicle;
import com.first.evaluation.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImplements implements VehicleService {
    @Autowired
    private VehicleRepository repo;


    @Override
    public void addVehicle(Vehicle v) {
        repo.save(v);
    }

    @Override
    public Vehicle getByNumber(String number) {
        return repo.findByNumber(number);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return repo.findAll();
    }

    @Override
    public List<Vehicle> getAvailableVehicles1() {
        return repo.getAvailableVehicles1();
    }

    @Override
    public List<Vehicle> getAvailableVehicles2() {
        return repo.getAvailableVehicles2();
    }

    @Override
    public void setNewKm(String number, double newKm) {
        repo.setNewKm(newKm,number);
    }


}
