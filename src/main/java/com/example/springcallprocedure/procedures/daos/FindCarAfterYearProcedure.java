package com.example.springcallprocedure.procedures.daos;

import com.example.springcallprocedure.car.Car;
import com.example.springcallprocedure.commons.ProcedureConstant;
import com.example.springcallprocedure.procedures.mappers.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;
import java.util.Map;

@Component
public class FindCarAfterYearProcedure {
    @Autowired
    DataSource dataSource;
    public List<Car> procedure(Integer year) {

        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource)
                . withProcedureName(ProcedureConstant.FIND_CARS_AFTER_YEAR)
                .declareParameters(new SqlParameter[]{
                        new SqlParameter(ProcedureConstant.PI_YEAR, Types.INTEGER),
                        new SqlParameter(ProcedureConstant.PO_CARS, Types.REF_CURSOR)
                })
                .returningResultSet(ProcedureConstant.PO_CARS, new CarMapper());

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(ProcedureConstant.PI_YEAR,year);

        Map<String, Object> results = simpleJdbcCall.execute(mapSqlParameterSource);
        List<Car> carsOut = (List<Car>) results.get(ProcedureConstant.PO_CARS);

        return carsOut;

    }
}
