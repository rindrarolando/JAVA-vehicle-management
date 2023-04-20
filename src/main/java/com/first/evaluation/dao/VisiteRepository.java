package com.first.evaluation.dao;

import com.first.evaluation.entities.Visite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VisiteRepository extends JpaRepository<Visite, Integer> {
    @Query(value = "SELECT * FROM visite WHERE numbervehicle=?1",nativeQuery = true)
    Visite getVisitOfVehicle(String numero);
}