package com.example.app.CarServiceApplication.controllers;

import com.example.app.CarServiceApplication.data.Part;
import com.example.app.CarServiceApplication.services.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/parts")
public class PartController {
    @Autowired
    private PartService partService;

    @GetMapping("/all")
    public List<Part> findAll() {
        return partService.findAll();
    }

    @GetMapping("/{id}")
    public Part findById(@PathVariable Long id) {
        return partService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Part part) {
        partService.save(part);
    }

//    @PostMapping("/all")
//    public void deleteAll() {
//        partService.deleteAll();
//    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        partService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Part part) {
        partService.update(id, part);
    }
}

