package com.example.autoservice.dto.request;

import java.util.List;

public class OwnerRequestDto {
    private List<Long> carsId;
    private List<Long> ordersId;

    public List<Long> getCarsId() {
        return carsId;
    }

    public List<Long> getOrdersId() {
        return ordersId;
    }
}
