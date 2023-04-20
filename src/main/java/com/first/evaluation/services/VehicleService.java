package com.first.evaluation.services;

import com.first.evaluation.entities.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    public void addVehicle(Vehicle v);

    public Vehicle getByNumber(String number);

    public List<Vehicle> getAllVehicles();

    public List<Vehicle> getAvailableVehicles1();

    public List<Vehicle> getAvailableVehicles2();

    public void setNewKm(String number , double newKm);
}
