package com.example.springcallprocedure.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    @Procedure("GET_TOTAL_CARS_BY_MODEL")
    //@Procedure(value = "GET_TOTAL_CARS_BY_MODEL")
    //@Procedure(procedureName = "GET_TOTAL_CARS_BY_MODEL")
    //@Procedure(name = "Car.getTotalCarsbyModelEntity")
    int getTotalCarsByModel(String model);

    @Query(value = "CALL FIND_CARS_AFTER_YEAR(:year_in);", nativeQuery = true)

    List<Car> findCarsAfterYear(@Param("year_in") Integer year_in);
}