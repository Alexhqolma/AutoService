package com.example.autoservice.dto.mapper;

import com.example.autoservice.dto.request.ServiceForCarRequestDto;
import com.example.autoservice.dto.response.ServiceForCarResponseDto;
import com.example.autoservice.model.ServiceForCar;
import com.example.autoservice.service.MasterService;
import com.example.autoservice.service.OrderService;
import org.springframework.stereotype.Component;

@Component
public class ServiceForCarMapper implements RequestDtoMapper<ServiceForCarRequestDto,
        ServiceForCar>,
        ResponseDtoMapper<ServiceForCarResponseDto, ServiceForCar> {
    private final OrderService orderService;
    private final MasterService masterService;

    public ServiceForCarMapper(OrderService orderService, MasterService masterService) {
        this.orderService = orderService;
        this.masterService = masterService;
    }

    @Override
    public ServiceForCar mapToModel(ServiceForCarRequestDto dto) {
        ServiceForCar serviceForCar = new ServiceForCar();
        serviceForCar.setOrder(orderService.findById(dto.getOrderId()));
        serviceForCar.setMaster(masterService.findById(dto.getMasterId()));
        serviceForCar.setPrice(dto.getPrice());
        serviceForCar.setStatus(dto.getStatus());
        return serviceForCar;
    }

    @Override
    public ServiceForCarResponseDto mapToDto(ServiceForCar serviceForCar) {
        ServiceForCarResponseDto serviceForCarResponseDto = new ServiceForCarResponseDto();
        serviceForCarResponseDto.setId(serviceForCar.getId());
        serviceForCarResponseDto.setOrderId(serviceForCar.getOrder().getId());
        serviceForCarResponseDto.setMasterId(serviceForCar.getMaster().getId());
        serviceForCarResponseDto.setPrice(serviceForCar.getPrice());
        serviceForCarResponseDto.setStatus(serviceForCar.getStatus());
        return serviceForCarResponseDto;
    }
}
