package com.example.autoservice.dto.response;

import com.example.autoservice.model.Status;
import lombok.Data;

@Data
public class ServiceForCarResponseDto {
    private Long id;
    private Long orderId;
    private Long masterId;
    private double price;
    private Status status;
}
