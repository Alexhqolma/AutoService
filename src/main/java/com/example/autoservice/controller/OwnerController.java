package com.example.autoservice.controller;

import java.util.List;
import java.util.stream.Collectors;
import com.example.autoservice.dto.mapper.OrderMapper;
import com.example.autoservice.dto.mapper.OwnerMapper;
import com.example.autoservice.dto.request.OwnerRequestDto;
import com.example.autoservice.dto.response.OrderResponseDto;
import com.example.autoservice.dto.response.OwnerResponseDto;
import com.example.autoservice.model.Owner;
import com.example.autoservice.service.OwnerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;
    private final OwnerMapper ownerMapper;
    private final OrderMapper orderMapper;

    public OwnerController(OwnerService ownerService, OwnerMapper ownerMapper, OrderMapper orderMapper) {
        this.ownerService = ownerService;
        this.ownerMapper = ownerMapper;
        this.orderMapper = orderMapper;
    }

    @PostMapping
    public OwnerResponseDto create(@RequestBody OwnerRequestDto ownerRequestDto) {
        Owner owner = ownerService.save(ownerMapper.mapToModel(ownerRequestDto));
        return ownerMapper.mapToDto(owner);
    }

    @PutMapping("/{id}")
    public OwnerResponseDto update(@PathVariable Long id, @RequestBody OwnerRequestDto ownerRequestDto) {
        Owner owner = ownerMapper.mapToModel(ownerRequestDto);
        owner.setId(id);
        return ownerMapper.mapToDto(ownerService.save(owner));
    }

    @GetMapping("/orders/{id}")
    public List<OrderResponseDto> findAllOrders(@PathVariable Long id) {
        return ownerService.findAllOrdersById(id)
                .stream()
                .map(orderMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
