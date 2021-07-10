package com.project.bike.controller;

import com.project.bike.model.Bike;
import com.project.bike.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/bikes")
public class BikesController {

    @Autowired
    private BikeRepository bikeRepository;

    @GetMapping
    public List<Bike> listOfBikes(){
        return bikeRepository.findAll();
    }
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public void createBike(@RequestBody Bike bike){
        bikeRepository.save(bike);
    }

    @GetMapping("/{id}")
    public Bike getBike(@PathVariable("id") long id){
        return bikeRepository.getById(id);
    }

}
