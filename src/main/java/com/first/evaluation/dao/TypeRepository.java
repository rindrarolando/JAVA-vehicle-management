package com.first.evaluation.dao;

import com.first.evaluation.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Integer> {
}