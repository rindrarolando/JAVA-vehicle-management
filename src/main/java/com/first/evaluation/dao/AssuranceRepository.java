package com.first.evaluation.dao;

import com.first.evaluation.entities.Assurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AssuranceRepository extends JpaRepository<Assurance, Integer> {
    @Query(value = "SELECT * FROM assurance WHERE numbervehicle=?1",nativeQuery = true)
    Assurance getAssuranceOfVehicle(String numero);
}