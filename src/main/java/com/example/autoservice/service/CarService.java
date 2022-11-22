package com.example.autoservice.service;

import com.example.autoservice.model.Car;

public interface CarService {
    Car save(Car car);

    Car update(Car car);

    Car findById(Long id);
}
