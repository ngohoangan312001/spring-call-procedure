package com.example.springcallprocedure;

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
    @Column(name="car_id")
    private long id;

    @Column
    private String model;

    @Column
    private String name;

    @Column
    private Integer year;

    // standard getters and setters
}

