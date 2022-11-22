package com.example.autoservice.dto.request;

import java.util.List;

public class MasterRequestDto {
    private String fio;
    private List<Long> readyOrdersId;

    public String getFio() {
        return fio;
    }

    public List<Long> getReadyOrdersId() {
        return readyOrdersId;
    }
}
