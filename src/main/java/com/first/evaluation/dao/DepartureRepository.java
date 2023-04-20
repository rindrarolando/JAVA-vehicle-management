package com.first.evaluation.dao;

import com.first.evaluation.entities.Departure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartureRepository extends JpaRepository<Departure, Integer> {
    @Query(value = "SELECT nextval('trajectory_id_seq')",nativeQuery = true)
    int getNextVal();

    @Query(value ="SELECT * FROM trajectory t JOIN vehicle v ON t.numbervehicle=v.number WHERE iddriver = ?1 AND status=false" ,nativeQuery = true)
    List<Departure> getDeparturesByIdOfDriver(int id);
}