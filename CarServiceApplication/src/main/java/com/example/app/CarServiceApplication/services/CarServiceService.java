package com.example.app.CarServiceApplication.services;

import com.example.app.CarServiceApplication.data.CarService;
import com.example.app.CarServiceApplication.data.Database;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceService {
    private Database database = new Database();

    public List<CarService> findAll() {
        return database.getCarServiceArrayList();
    }

    public CarService findById(long id) {
        for (int i = 0; i < database.getCarServiceArrayList().size(); i++) {
            if (database.getCarServiceArrayList().get(i).getId() == (id)) {
                return database.getCarServiceArrayList().get(i);
            }
        }
        return null;
    }

    public void save(CarService carService) {
        database.setCarServiceArrayList(carService);
    }

   // public void deleteAll() {
     //   database.getCarServiceArrayList().clear();
    //}

    public void deleteByID(long id) {
        database.getCarServiceArrayList().remove(findById(id));
    }

    public void update(long id, CarService carService) {
        CarService toUpdateCarService = findById(id);
        toUpdateCarService.setId(carService.getId());
        toUpdateCarService.setLocation(carService.getLocation());

    }
}
