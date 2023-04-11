package com.example.app.CarServiceApplication.data;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Part {
    private long id;
    private String title;
    private int year;
}
