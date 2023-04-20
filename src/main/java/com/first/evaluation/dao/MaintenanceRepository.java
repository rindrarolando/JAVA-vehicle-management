package com.first.evaluation.dao;

import com.first.evaluation.entities.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {
}