package com.example.app.CarServiceApplication.data;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Owner {
    private long id;
    private String name;
    private int NumberOfVisits;
}
