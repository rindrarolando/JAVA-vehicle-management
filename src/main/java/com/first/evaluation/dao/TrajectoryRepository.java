package com.first.evaluation.dao;

import com.first.evaluation.entities.Trajectory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrajectoryRepository extends JpaRepository<Trajectory, Integer> {

    @Query(value = "SELECT * FROM trajectory WHERE numbervehicle=?1"
            ,nativeQuery = true)
    List<Trajectory> getByVehicleNumber(String number);

    @Query(value = "SELECT * FROM trajectory WHERE iddriver=?1"
            ,nativeQuery = true)
    Trajectory getByDriver(int iddriver);
}