package com.first.evaluation.dao;

import com.first.evaluation.entities.Arrival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArrivalRepository extends JpaRepository<Arrival, Integer> {

    @Query(value = "SELECT nextval('arrival_id_seq')",nativeQuery = true)
    int getNextval();
}