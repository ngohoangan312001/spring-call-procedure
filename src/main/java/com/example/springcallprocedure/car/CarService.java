package com.example.springcallprocedure.car;

import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarService {
    int getTotalCarsByModel(String model);
    List<Car> findCarsAfterYear(@Param("year_in") Integer year);

}
