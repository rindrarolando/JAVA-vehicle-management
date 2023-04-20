package com.first.evaluation.services;

import com.first.evaluation.entities.Trajectory;

import java.util.List;

public interface TrajectoryService {

    public void addTrajectory(Trajectory trajet);

    Trajectory getById(int id);

    List<Trajectory> getByVehicleNumber(String number);

    Trajectory getByDriver(int id);
}
