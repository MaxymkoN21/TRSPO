
package com.example.app.CarServiceApplication.controllers;

import com.example.app.CarServiceApplication.data.Owner;
import com.example.app.CarServiceApplication.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/owners")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping("/all")
    public List<Owner> findAll() {
        return ownerService.findAll();
    }

    @GetMapping("/{id}")
    public Owner findById(@PathVariable long id) {
        return ownerService.findById(id);
    }


    @PostMapping
    public void save(@RequestBody Owner owner) {
        ownerService.save(owner);
    }

//    @DeleteMapping("/all")
//    public void deleteAll() {
//        ownerService.deleteAll();
//    }

    @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable long id) {
        ownerService.deleteByID(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Owner owner) {
        ownerService.update(id, owner);
    }
}


