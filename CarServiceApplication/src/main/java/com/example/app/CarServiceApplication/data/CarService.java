package com.example.app.CarServiceApplication.data;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarService {
    private long id;
    private String location;
    private int rating;
}
