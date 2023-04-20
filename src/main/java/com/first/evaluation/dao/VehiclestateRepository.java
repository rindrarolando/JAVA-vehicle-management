package com.first.evaluation.dao;

import com.first.evaluation.views.Vehiclestate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehiclestateRepository extends JpaRepository<Vehiclestate, String> {

    @Query(value = "SELECT * FROM vehiclestate WHERE number = ?1",
            nativeQuery = true)
    Vehiclestate getVehicleStates(String number);

    @Query(value = "SELECT * FROM vehiclestate",
            nativeQuery = true)
    List<Vehiclestate> getAllVehicleStates();

}