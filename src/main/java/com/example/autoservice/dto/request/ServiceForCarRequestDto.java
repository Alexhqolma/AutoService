package com.example.autoservice.dto.request;

import com.example.autoservice.model.Status;

public class ServiceForCarRequestDto {
    private Long orderId;
    private Long masterId;
    private double price;
    private Status status;

    public Long getOrderId() {
        return orderId;
    }

    public Long getMasterId() {
        return masterId;
    }

    public double getPrice() {
        return price;
    }

    public Status getStatus() {
        return status;
    }
}
