package com.first.evaluation;

import com.first.evaluation.dao.VehicleRepository;
import com.first.evaluation.entities.Vehicle;
import com.first.evaluation.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EvaluationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvaluationApplication.class, args);
	}

	}
