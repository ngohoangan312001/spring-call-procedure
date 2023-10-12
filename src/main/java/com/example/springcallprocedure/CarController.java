package com.example.springcallprocedure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("/count")
    public int getTotalCarsByModel(@RequestParam(name = "model") String model) throws Exception {
        int count = carService.getTotalCarsByModel(model);
        return count;
    }

    @GetMapping("/find")
    public List<Car> getTotalCarsByModel(@RequestParam(name = "year") int year) throws Exception {
        List<Car> carsAfterYear = carService.test(year);
        return carsAfterYear;
    }

}
