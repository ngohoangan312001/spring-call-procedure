package com.example.springcallprocedure.procedures.mappers;

import com.example.springcallprocedure.car.Car;
import com.example.springcallprocedure.commons.EntityConstant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CarMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt(EntityConstant.ID));
        car.setModel(rs.getString(EntityConstant.MODEL));
        car.setName(rs.getString(EntityConstant.NAME));
        car.setYear(rs.getInt(EntityConstant.YEAR));
        return car;
    }
}
