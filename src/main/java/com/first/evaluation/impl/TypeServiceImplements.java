package com.first.evaluation.impl;

import com.first.evaluation.dao.TypeRepository;
import com.first.evaluation.entities.Type;
import com.first.evaluation.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImplements implements TypeService {

    @Autowired
    private TypeRepository repo;

    @Override
    public List<Type> getAllTypes() {
        return repo.findAll();
    }

    @Override
    public Type getByid(int id) {
        return repo.getById(id);
    }
}
