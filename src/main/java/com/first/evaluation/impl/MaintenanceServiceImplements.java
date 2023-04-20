package com.first.evaluation.impl;

import com.first.evaluation.dao.MaintenanceRepository;
import com.first.evaluation.services.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceServiceImplements implements MaintenanceService {
    @Autowired
    MaintenanceRepository repo;
}
