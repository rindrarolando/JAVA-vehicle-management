package com.first.evaluation.services;

import com.first.evaluation.dao.TypeRepository;
import com.first.evaluation.entities.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TypeService {


    public List<Type> getAllTypes();

    public Type getByid(int id);

}
