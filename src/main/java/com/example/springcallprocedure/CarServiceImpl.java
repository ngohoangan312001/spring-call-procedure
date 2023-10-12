package com.example.springcallprocedure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

@Service
public class CarServiceImpl implements CarService{
    @Autowired
    private CarRepository cardRepository;
    @Autowired
    DataSource dataSource;
    @Override
    public int getTotalCarsByModel(String model) {
        return cardRepository.getTotalCarsByModel(model);
    }

    @Override
    public List<Car> findCarsAfterYear(Integer year) {
        return cardRepository.findCarsAfterYear(year);
    }

    public List<Car> test(Integer year) {

        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource)
                .withProcedureName("FIND_CARS_AFTER_YEAR")
                .declareParameters(new SqlParameter[]{
                        new SqlParameter("year_in", Types.INTEGER),
                        new SqlParameter("cars_out", Types.REF_CURSOR)
                })
                .returningResultSet("cars_out", new RowMapper<Car>() {
                    @Override
                    public Car mapRow(ResultSet rs, int rowNum) throws SQLException{
                        Car car = new Car();
                        car.setId(rs.getInt(1));
                        car.setModel(rs.getString(2));
                        car.setName(rs.getString(3));
                        car.setYear(rs.getInt(4));
                        return car;
                    }
                });

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("year_in",year);

        Map<String, Object> results = simpleJdbcCall.execute(mapSqlParameterSource);
        List<Car> carsOut = (List<Car>) results.get("cars_out");

        return carsOut;

    }
}
