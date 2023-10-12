package com.example.springcallprocedure.car;

import com.example.springcallprocedure.commons.EntityConstant;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@NamedStoredProcedureQuery(name = "Car.getTotalCarsbyModelEntity",procedureName = "GET_TOTAL_CARS_BY_MODEL", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "model_in", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "count_out", type = Integer.class)})
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= EntityConstant.ID)
    private long id;

    @Column(name = EntityConstant.MODEL)
    private String model;

    @Column(name = EntityConstant.NAME)
    private String name;

    @Column(name = EntityConstant.YEAR)
    private Integer year;

    // standard getters and setters
}

