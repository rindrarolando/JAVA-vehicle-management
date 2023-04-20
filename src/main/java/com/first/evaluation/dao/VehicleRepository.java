package com.first.evaluation.dao;

import com.first.evaluation.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

    @Query(
            value = "SELECT * FROM vehicle WHERE number NOT IN (SELECT number FROM trajectory)",
            nativeQuery = true)
    List<Vehicle> getAvailableVehicles1();

    @Query(
            value = "SELECT * FROM vehicle v JOIN trajectory t ON v.number=t.numbervehicle WHERE status=TRUE AND arrival_place='garage'",
            nativeQuery = true)
    List<Vehicle> getAvailableVehicles2();

    @Query(
            value = "SELECT * FROM vehicle WHERE number= ?1",
            nativeQuery = true)
    Vehicle findByNumber(String number);

    @Transactional
    @Query(
            value = "UPDATE vehicle SET km= ?1 WHERE number= ?2",
            nativeQuery = true)
    void setNewKm(double newKm,String number);
}