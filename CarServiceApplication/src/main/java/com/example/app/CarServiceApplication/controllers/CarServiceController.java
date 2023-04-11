package com.example.app.CarServiceApplication.controllers;

import com.example.app.CarServiceApplication.data.CarService;
import com.example.app.CarServiceApplication.services.CarServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/services")
public class CarServiceController {
    private CarServiceService carServiceService = new CarServiceService();

    @GetMapping("/all")
    public List<CarService> findAll() {
        return carServiceService.findAll();
    }

    @GetMapping("/{id}")
    public CarService findById(@PathVariable long id) {
        return carServiceService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody CarService carService) {
        carServiceService.save(carService);
    }

//    @DeleteMapping("/all")
//    public void deleteAll() {
//        carServiceService.deleteAll();
//    }

    @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable long id) {
        carServiceService.deleteByID(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody CarService carService) {
        carServiceService.update(id, carService);
    }
}

