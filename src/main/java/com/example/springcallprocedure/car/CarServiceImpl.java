package com.example.springcallprocedure.car;

import com.example.springcallprocedure.procedures.daos.FindCarAfterYearProcedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    @Autowired
    private CarRepository cardRepository;

    @Autowired
    private FindCarAfterYearProcedure findCarAfterYearProcedure;

    @Override
    public int getTotalCarsByModel(String model) {
        return cardRepository.getTotalCarsByModel(model);
    }

    @Override
    public List<Car> findCarsAfterYear(Integer year) {
        return findCarAfterYearProcedure.procedure(year);
    }


}
