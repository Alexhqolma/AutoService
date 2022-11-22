package com.example.autoservice.service.impl;

import com.example.autoservice.model.ServiceForCar;
import com.example.autoservice.model.Status;
import com.example.autoservice.repository.ServiceForCarRepository;
import com.example.autoservice.service.ServiceForCarService;
import org.springframework.stereotype.Service;

@Service
public class ServiceForCarServiceImpl implements ServiceForCarService {
    private final ServiceForCarRepository serviceForCarRepository;

    public ServiceForCarServiceImpl(ServiceForCarRepository serviceForCarRepository) {
        this.serviceForCarRepository = serviceForCarRepository;
    }

    @Override
    public ServiceForCar save(ServiceForCar serviceForCar) {
        return serviceForCarRepository.save(serviceForCar);
    }

    @Override
    public ServiceForCar update(ServiceForCar serviceForCar) {
        return serviceForCarRepository.save(serviceForCar);
    }

    @Override
    public ServiceForCar serviceStatus(Long serviceId, ServiceForCar serviceForCar, Status status) {
        return serviceForCarRepository.save(serviceForCar);
    }

    @Override
    public ServiceForCar findById(Long id) {
        return serviceForCarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find service by id " + id));
    }
}
