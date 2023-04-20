package com.first.evaluation.impl;

import com.first.evaluation.dao.TrajectoryRepository;
import com.first.evaluation.entities.Trajectory;
import com.first.evaluation.services.TrajectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrajectoryServiceImplements implements TrajectoryService {
    @Autowired
    TrajectoryRepository repo;

    @Override
    public void addTrajectory(Trajectory trajet) {
        repo.save(trajet);
    }

    @Override
    public Trajectory getById(int id) {
        return repo.getById(id);
    }

    @Override
    public List<Trajectory> getByVehicleNumber(String number) {
        return repo.getByVehicleNumber(number);
    }

    @Override
    public Trajectory getByDriver(int id) {
        return repo.getByDriver(id);
    }
}
