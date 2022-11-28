package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.ServiceForCarMapper;
import com.example.autoservice.dto.request.ServiceForCarRequestDto;
import com.example.autoservice.dto.response.ServiceForCarResponseDto;
import com.example.autoservice.model.ServiceForCar;
import com.example.autoservice.model.Status;
import com.example.autoservice.service.ServiceForCarService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class ServiceForCarController {
    private final ServiceForCarService serviceForCarService;
    private final ServiceForCarMapper serviceForCarMapper;

    public ServiceForCarController(ServiceForCarService serviceForCarService,
                                   ServiceForCarMapper serviceForCarMapper) {
        this.serviceForCarService = serviceForCarService;
        this.serviceForCarMapper = serviceForCarMapper;
    }

    @PostMapping
    public ServiceForCarResponseDto create(
            @RequestBody ServiceForCarRequestDto serviceForCarRequestDto) {
        ServiceForCar serviceForCar = serviceForCarService
                .save(serviceForCarMapper
                        .mapToModel(serviceForCarRequestDto));
        return serviceForCarMapper.mapToDto(serviceForCar);
    }

    @PutMapping("/{id}")
    public ServiceForCarResponseDto update(@PathVariable Long id,
            @RequestBody ServiceForCarRequestDto serviceForCarRequestDto) {
        ServiceForCar serviceForCar =
                serviceForCarMapper.mapToModel(serviceForCarRequestDto);
        serviceForCar.setId(id);
        return serviceForCarMapper
                .mapToDto(serviceForCarService.save(serviceForCar));
    }

    @PutMapping("/update-status/{id}")
    public ServiceForCarResponseDto changeStatus(@PathVariable Long id,
            @RequestBody ServiceForCarRequestDto serviceForCarRequestDto,
            @RequestBody Status status) {
        ServiceForCar serviceForCar =
                serviceForCarMapper.mapToModel(serviceForCarRequestDto);
        serviceForCar.setId(id);
        serviceForCar.setStatus(status);
        return serviceForCarMapper.mapToDto(serviceForCarService.save(serviceForCar));
    }
}
